package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Badge;

import java.util.List;

public interface BadgeService {

    void addOneBadge(Badge badge);
    void deactivateOneBadgeByBadgeId(int id);
  List<Badge> findAllBadgesOfOneMemberByMemberId(int id);
}
