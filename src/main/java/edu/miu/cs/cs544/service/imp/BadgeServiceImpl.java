package edu.miu.cs.cs544.service.imp;

import edu.miu.cs.cs544.model.Badge;
import edu.miu.cs.cs544.repository.BadgeRepository;
import edu.miu.cs.cs544.service.BadgeService;
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
        badge.setStatus(false);
    }

    @Override
    public List<Badge> findAllBadgesOfOneMemberByMemberId() {
       return  badgeRepository.findAll();
    }
}