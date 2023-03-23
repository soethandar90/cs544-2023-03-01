package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.util.BadgeStatusType;
import edu.miu.cs.cs544.util.BadgeTransactionType;
import edu.miu.cs.cs544.contract.BadgeTransactionRequestDTO;
import edu.miu.cs.cs544.exception.InvalidTransactionException;
import edu.miu.cs.cs544.model.*;
import edu.miu.cs.cs544.repository.*;
import edu.miu.cs.cs544.service.BadgeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class BadgeTransactionImpl implements BadgeTransactionService {

    @Autowired
    private BadgeTransactionRepository badgeTransactionRepository;
    @Autowired
    private BadgeRepository badgeRepository;

    @Autowired
    private MembershipRepository membershipRepository;
    @Autowired
    private TimeslotRepository timeslotRepository;

    @Autowired
    private MembershipPlanRepository membershipPlanRepository;

    @Autowired
    private LocationRepository locationRepository;



    @Override
    public boolean generateBadgeTransaction(BadgeTransaction badgeTransaction) {
        return false;
    }

    @Override
    public Optional<List<BadgeTransaction>> findAllBadgeTransactionByMemberId(int memberId) {
        return badgeTransactionRepository.findAllTransactionOfOneMemberByMemberId(memberId);
    }

    @Override
    public Badge filterActiveBadgeByMemberId(int memberId) {
        return null;
    }

    @Override
    public boolean generateBadgeTransaction(BadgeTransactionRequestDTO badgeTransactionRequestDTO) {
        MembershipPlan membershipPlan = membershipPlanRepository.findById(badgeTransactionRequestDTO.getPlan()).get();
        Location location = locationRepository.findById(badgeTransactionRequestDTO.getLocation()).get();
        Badge badge = badgeRepository.findByBadge(badgeTransactionRequestDTO.getBadge()).get();
        BadgeTransaction badgeTransaction = new BadgeTransaction();
        badgeTransaction.setBadge(badge);
        badgeTransaction.setPlan(membershipPlan);
        badgeTransaction.setLocation(location);
        badgeTransaction.setTransactionTime(LocalDateTime.now());
        ///badgeTransactionRepository.save(badgeTransaction);

        if (!isBadgeActive(badge)) {
            declineTransaction(badgeTransaction, "Badge Inactive");
            throw new InvalidTransactionException("transactionId","transactionTime", BadgeTransactionType.DECLINED.toString(),"Badge Inactive");
        }

        if (!isTimeslotActive(badgeTransaction.getTransactionTime(), badgeTransaction.getLocation().getLocationId())) {
            declineTransaction(badgeTransaction, "Timeslot Inactive");
            throw new InvalidTransactionException("transactionId","transactionTime",BadgeTransactionType.DECLINED.toString(),"Timeslot Inactive");
        }
        if (usageCount(badgeTransaction.getPlan().getPlanId(),badgeTransaction.getBadge().getMember().getMemberId()) == 0) {
            declineTransaction(badgeTransaction, "Insufficient usage balance");
            throw new InvalidTransactionException("transactionId","transactionTime",BadgeTransactionType.DECLINED.toString(),"Insufficient usage balance");
        }
        if (usageCountSameDaySlot(badgeTransaction)){
            declineTransaction(badgeTransaction, "Already Swiped Once");
            throw new InvalidTransactionException("transactionId","transactionTime",BadgeTransactionType.DECLINED.toString(),"Already Swiped Once");
        }

        approveTransaction(badgeTransaction);
        return false;
    }

    private boolean usageCountSameDaySlot(BadgeTransaction badgeTransaction) {

        //if exampted unlimited
        int exampted = membershipRepository.searchIfUnlimitedMembership(badgeTransaction.getBadge().getMember().getMemberId(),badgeTransaction.getPlan().getPlanId());
        if(exampted>0){
            return false;
        }  else {
            Timeslot timeslot = timeslotRepository.findTimeslotByLocationIdAndDay(badgeTransaction.getTransactionTime().getDayOfWeek().toString(), badgeTransaction.getLocation().getLocationId()).get();
            String start = LocalDate.now() + " " + timeslot.getStartTime();
            String end = LocalDate.now() + " " + timeslot.getEndTime();
            int count = badgeTransactionRepository.findCountByDate(badgeTransaction.getBadge().getBadgeId(), badgeTransaction.getLocation().getLocationId()
                    , badgeTransaction.getPlan().getPlanId(), start, end);

            if (count > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean isBadgeActive(Badge badge) {

        if (badge.getStatus().equals(BadgeStatusType.ACTIVE)) {
            return true;
        }
        return false;
    }

    public int usageCount(int membershipPlanId,int memberId) {
        return membershipRepository.findOneMembershipsOfOneMemberByMembershipId2(membershipPlanId,memberId).getCurrentUsage();
    }

    public boolean isTimeslotActive(LocalDateTime tranTime, int locationId) {
        Timeslot timeslot = timeslotRepository.findTimeslotByLocationIdAndDay(tranTime.getDayOfWeek().toString(), locationId).get();
        if (timeslot != null) {
            LocalTime transactionTime = tranTime.toLocalTime();
            if (transactionTime.compareTo(timeslot.getStartTime().toLocalTime()) >= 0
                    && transactionTime.compareTo(timeslot.getEndTime().toLocalTime()) <= 0) {
                return true;
            }
        }
        return false;
    }

    private void addOneTransaction(BadgeTransaction badgeTransaction) {
        badgeTransactionRepository.save(badgeTransaction);
    }

    private void decreaseUsage(int membershipPlanId,int memberId) {
        Membership membership = membershipRepository.findOneMembershipsOfOneMemberByMembershipId2(membershipPlanId,memberId);
        membership.setCurrentUsage(membership.getCurrentUsage() - 1);
        membershipRepository.save(membership);
    }

    //To make transactional.
    private void approveTransaction(BadgeTransaction badgeTransaction) {
        badgeTransaction.setTransactionType(BadgeTransactionType.ALLOWED);
        addOneTransaction(badgeTransaction);
        decreaseUsage(badgeTransaction.getPlan().getPlanId(),badgeTransaction.getBadge().getMember().getMemberId());
    }

    private void declineTransaction(BadgeTransaction badgeTransaction, String reason) {
        badgeTransaction.setTransactionType(BadgeTransactionType.DECLINED);
        badgeTransaction.setReason(reason);
        addOneTransaction(badgeTransaction);
    }

}

// ALL INFROMATION FROM BADGE TRANSACTION OBJECT AND TEST REFACTOR

