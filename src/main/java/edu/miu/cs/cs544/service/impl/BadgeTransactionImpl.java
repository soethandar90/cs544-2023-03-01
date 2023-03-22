package edu.miu.cs.cs544.service.impl;

import edu.miu.cs.cs544.common.BadgeStatusType;
import edu.miu.cs.cs544.common.BadgeTransactionType;
import edu.miu.cs.cs544.exception.InvalidTransactionException;
import edu.miu.cs.cs544.model.*;
import edu.miu.cs.cs544.repository.*;
import edu.miu.cs.cs544.service.BadgeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class BadgeTransactionImpl implements BadgeTransactionService {

    @Autowired
    private BadgeTransactionRepository badgeTransactionRepository;
    @Autowired
    private BadgeRepository badgeRepository;

    @Autowired
    private MembershipRepository membershipRepository;
    @Autowired
    private TimeslotRepository timeslotRepository;

    @Override
    public List<BadgeTransaction> findAllBadgeTransactionByMemberId(int memberId) {
        Badge badge = badgeRepository.findById(memberId).get();

        return badgeTransactionRepository.findAllById(Collections.singleton(memberId));
    }

    @Override
    public Badge filterActiveBadgeByMemberId(int memberId) {
        return null;
    }

    @Override
    public boolean generateBadgeTransaction(BadgeTransaction badgeTransaction) {

        if (!isBadgeActive(badgeTransaction.getBadge().getBadgeId())) {
            declineTransaction(badgeTransaction, "Badge Inactive");
            throw new InvalidTransactionException("transactionId","transactionTime", BadgeTransactionType.DECLINED.toString(),"Badge Inactive");
        }

        if (!isTimeslotActive(badgeTransaction.getTransactionTime(), badgeTransaction.getLocation().getLocationId())) {
            declineTransaction(badgeTransaction, "Timeslot Inactive");
            throw new InvalidTransactionException("transactionId","transactionTime",BadgeTransactionType.DECLINED.toString(),"Timeslot Inactive");
        }
        if (usageCount(badgeTransaction.getPlan().getPlanId()) == 0) {
            declineTransaction(badgeTransaction, "Insufficient usage balance");
            throw new InvalidTransactionException("transactionId","transactionTime",BadgeTransactionType.DECLINED.toString(),"Insufficient usage balance");
        }

        approveTransaction(badgeTransaction);
        return false;
    }

    private boolean isBadgeActive(int badgeId) {
        Badge badge = badgeRepository.findById(badgeId).get();
        if (badge.getStatus().equals(BadgeStatusType.ACTIVE)) {
            return true;
        }
        return false;
    }

    private int usageCount(int membershipPlanId) {
        return membershipRepository.findOneMembershipsOfOneMemberByMembershipId(membershipPlanId).getCurrentUsage();
    }

    private boolean isTimeslotActive(LocalDateTime tranTime, int locationId) {
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

    private void decreaseUsage(int membershipPlanId) {
        Membership membership = membershipRepository.findOneMembershipsOfOneMemberByMembershipId(membershipPlanId);
        membership.setCurrentUsage(membership.getCurrentUsage() - 1);
        membershipRepository.save(membership);
    }

    //To make transactional.
    private void approveTransaction(BadgeTransaction badgeTransaction) {
        badgeTransaction.setTransactionType(BadgeTransactionType.ALLOWED);
        addOneTransaction(badgeTransaction);
        decreaseUsage(badgeTransaction.getPlan().getPlanId());
    }

    private void declineTransaction(BadgeTransaction badgeTransaction, String reason) {
        badgeTransaction.setTransactionType(BadgeTransactionType.DECLINED);
        badgeTransaction.setReason(reason);
        addOneTransaction(badgeTransaction);
    }

}

// ALL INFROMATION FROM BADGE TRANSACTION OBJECT AND TEST REFACTOR

