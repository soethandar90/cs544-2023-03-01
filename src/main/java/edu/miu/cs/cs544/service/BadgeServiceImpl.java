package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Badge;
import edu.miu.cs.cs544.repository.BadgeRepository;
import edu.miu.cs.cs544.util.BadgeStatusType;
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
    public Badge addOneBadge(Badge badge) {
        deactivateOneBadgeByMemberId(badge.getMember().getMemberId());
        return badgeRepository.save(badge);
    }

    @Override
    public void deactivateOneBadgeByMemberId(int memberId) {
        Badge badge = badgeRepository.findActiveBadgeByMemberId(memberId);
        if(badge!=null){
            badge.setStatus(BadgeStatusType.INACTIVE);
            badgeRepository.save(badge);
        }
    }

    @Override
    public List<Badge> findAllBadgesOfOneMemberByMemberId(int id) {
        return badgeRepository.findAllByMemberId(id).get();
    }

}
