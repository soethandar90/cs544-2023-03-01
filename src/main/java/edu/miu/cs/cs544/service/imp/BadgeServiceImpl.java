package edu.miu.cs.cs544.service.imp;

import edu.miu.cs.cs544.model.Badge;
import edu.miu.cs.cs544.model.BadgeStatusType;
import edu.miu.cs.cs544.repository.BadgeRepository;
import edu.miu.cs.cs544.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional

public class BadgeServiceImpl implements BadgeService {
    @Autowired
    public BadgeRepository badgeRepository;


    @Override
    public void addOneBadge(Badge badge) {
        badgeRepository.save(badge);
    }

    @Override
    public void deactivateOneBadgeByBadgeId(int id) {
        Badge badge=badgeRepository.findById(id).get();
        badge.setStatus(BadgeStatusType.INACTIVE);
    }

    @Override
    public List<Badge> findAllBadgesOfOneMemberByMemberId(int id) {
       return  badgeRepository.findAllById(Collections.singleton(id));
    }

    @Override
    public boolean isBadgeActive(int badgeId) {
        return false;
    }


//    @Override
//    public boolean isBadgeActive(int badgeId) {
//
//        Badge badge = badgeRepository.findById(badgeId).orElse(null);
//        if(badge==null)
//        {
//            return false;
//        }
//        else
//        return badge.isStatus();
//    }

}
