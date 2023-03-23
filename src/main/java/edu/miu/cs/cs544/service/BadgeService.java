package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Badge;

import java.util.List;

public interface BadgeService {

    Badge addOneBadge(Badge badge);

    Badge deactivateOneBadgeByMemberId(int id);

    List<Badge> findAllBadgesOfOneMemberByMemberId(int id);
}
