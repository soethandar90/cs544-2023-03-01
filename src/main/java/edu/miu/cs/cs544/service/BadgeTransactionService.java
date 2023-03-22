package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.contract.BadgeTransactionRequestDTO;
import edu.miu.cs.cs544.model.Badge;
import edu.miu.cs.cs544.model.BadgeTransaction;

import java.util.List;

public interface BadgeTransactionService {

    // find all badge Transaction of  one memner by member id

    public boolean generateBadgeTransaction(BadgeTransaction badgeTransaction);

    List<BadgeTransaction> findAllBadgeTransactionByMemberId(int memberId);

    public Badge filterActiveBadgeByMemberId(int memberId);

    public boolean generateBadgeTransaction(BadgeTransactionRequestDTO badgeTransaction);
}
