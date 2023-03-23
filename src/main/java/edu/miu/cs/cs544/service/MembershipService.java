package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Membership;

import java.util.List;
import java.util.Optional;

public interface MembershipService {
    void addOneMembership(Membership membership);

    void updateOneMembershipByMembershipId(Membership membership);

    void deleteOneMembershipByMembershipId(int membershipId);

    Optional<List<Membership>> findAllMembershipsOfOneMemberByMemberId(int memberId);
}
