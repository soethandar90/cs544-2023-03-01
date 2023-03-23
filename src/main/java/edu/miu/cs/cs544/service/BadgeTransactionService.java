package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.contract.BadgeTransactionDTO;
import edu.miu.cs.cs544.model.Badge;
import edu.miu.cs.cs544.model.BadgeTransaction;

import java.util.List;
import java.util.Optional;

public interface BadgeTransactionService {
    boolean generateBadgeTransaction(BadgeTransaction badgeTransaction);

    Optional<List<BadgeTransaction>> findAllBadgeTransactionByMemberId(int memberId);

    Badge filterActiveBadgeByMemberId(int memberId);

    boolean generateBadgeTransaction(BadgeTransactionDTO badgeTransaction);

    boolean isBadgeActive(Badge badge);

}
