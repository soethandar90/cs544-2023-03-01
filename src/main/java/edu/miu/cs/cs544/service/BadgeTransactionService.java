package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Badge;
import edu.miu.cs.cs544.model.BadgeTransaction;

import java.util.List;

public interface BadgeTransactionService {

    public void addOneTransaction(BadgeTransaction badgeTransaction);

    //fileter active badge of one member by member id
    public Badge filterActiveBadgeByMemberId(int memberId);

   // find all badge Transaction of  one memner by member id


    List<BadgeTransaction> findAllBadgeTransactionByMemberId(int memberId);

    void generateBadgeTransaction(int badgeId);


}

//
//    @Override
//    public Badge filterActiveBadgeByMemberId(int memberId) {
//        return null;
//    }
//
//    @Override
//    public List<BadgeTransaction> findAllBadgeTransactionByMemberId(int memberId) {
//        return null;
//    }
//
//    @Override
//    public void generateBadgeTransaction(int badgeId) {
//
//    }