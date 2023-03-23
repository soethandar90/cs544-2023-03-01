package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Badge;
import edu.miu.cs.cs544.util.BadgeStatusType;
import edu.miu.cs.cs544.repository.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
       return  badgeRepository.findAllByMemberId(id).get();
    }

}
