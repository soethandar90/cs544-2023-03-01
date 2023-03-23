package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.contract.BadgeTransactionRequestDTO;
import edu.miu.cs.cs544.model.Badge;
import edu.miu.cs.cs544.model.BadgeTransaction;

import java.util.List;
import java.util.Optional;

public interface BadgeTransactionService {
    boolean generateBadgeTransaction(BadgeTransaction badgeTransaction);

    Optional<List<BadgeTransaction>> findAllBadgeTransactionByMemberId(int memberId);

    Badge filterActiveBadgeByMemberId(int memberId);

    boolean generateBadgeTransaction(BadgeTransactionRequestDTO badgeTransaction);

    boolean isBadgeActive(Badge badge);

}
