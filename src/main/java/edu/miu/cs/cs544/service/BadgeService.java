package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.contract.BadgeDTO;
import edu.miu.cs.cs544.model.Badge;

import java.util.List;

public interface BadgeService {

    Badge addOneBadge(Badge badge);

    void deactivateOneBadgeByMemberId(int id);

    List<BadgeDTO> findAllBadgesOfOneMemberByMemberId(int id);
}
