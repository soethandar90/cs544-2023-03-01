package edu.miu.cs.cs544.service.imp;

import edu.miu.cs.cs544.model.Badge;
import edu.miu.cs.cs544.model.BadgeTransaction;
import edu.miu.cs.cs544.model.Timeslot;
import edu.miu.cs.cs544.repository.BadgeRepository;
import edu.miu.cs.cs544.repository.BadgeTransactionRepository;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.repository.TimeslotRepository;
import edu.miu.cs.cs544.service.BadgeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private MemberRepository memberRepository;
    @Autowired
    private TimeslotRepository timeslotRepository;


    @Override
    public void addOneTransaction(BadgeTransaction badgeTransaction) {
        badgeTransactionRepository.save(badgeTransaction);
    }

    @Override
    public Badge filterActiveBadgeByMemberId(int memberId) {

        Badge badge = badgeRepository.findById(memberId).get();

        if (badge.getStatus().equals("ACTIVE")) {
            return badge;
        }
        else if (badge.getStatus().equals("INACTIVE")){
            throw new IllegalArgumentException("BADGE IS INACTIVE");
        }
        throw new IllegalArgumentException(" IS NOT USABLE ");


    }

    //retrieving all the badge transactions associated with a single member
    @Override
    public List<BadgeTransaction> findAllBadgeTransactionByMemberId(int memberId) {
        Badge badge = badgeRepository.findById(memberId).get();

        return badgeTransactionRepository.findAllById(Collections.singleton(memberId));
    }

    public boolean isMemberActive(int badgeId) {
       Badge badge = badgeRepository.findById(badgeId).get();
        if(badge.getStatus().equals("ACTIVE")) {
            return true;
        }
        return false;
    }


    public int usageCount(Badge badge) {
        return 0;
    }


    public boolean activeTimeSlot(int timeslotId) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Timeslot timeslot = timeslotRepository.findById(timeslotId).get();
        if (currentDateTime.toLocalTime().compareTo(timeslot.getStartTime().toLocalTime()) >= 0
                && currentDateTime.toLocalTime().compareTo(timeslot.getEndTime().toLocalTime()) <= 0) {
            return true;
        }
        return false;
    }


    @Override
    public void generateBadgeTransaction(int badgeId) {

        Badge badge = badgeRepository.findById(badgeId).get();

        if(badge.getStatus().equals("ACTIVE") && activeTimeSlot(badgeId) && isMemberActive(badgeId) && (usageCount(badge)>0)){
            BadgeTransaction badgeTransaction = new BadgeTransaction();
            badgeTransaction.setBadge(badge);
            badgeTransaction.setTransactionTime(LocalDate.now());
            // PLAN ID AND LOCATION ID

            badgeTransactionRepository.save(badgeTransaction);

            addOneTransaction(badgeTransaction);

            } else {
                throw new IllegalStateException("Badge is inactive.");
            }
    }
}

// ALL INFROMATION FROM BADGE TRANSACTION OBJECT AND TEST REFACTOR

