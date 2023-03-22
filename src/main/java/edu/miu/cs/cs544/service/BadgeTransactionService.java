package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.contract.BadgeTransactionRequestDTO;
import edu.miu.cs.cs544.model.Badge;
import edu.miu.cs.cs544.model.BadgeTransaction;
import edu.miu.cs.cs544.model.Location;

import java.util.List;
import java.util.Optional;

public interface BadgeTransactionService {

    // find all badge Transaction of  one memner by member id

    public boolean generateBadgeTransaction(BadgeTransaction badgeTransaction);

    Optional<List<BadgeTransaction>> findAllBadgeTransactionByMemberId(int memberId);

    public Badge filterActiveBadgeByMemberId(int memberId);

    public boolean generateBadgeTransaction(BadgeTransactionRequestDTO badgeTransaction);

    public boolean isBadgeActive(Badge badge);

}
