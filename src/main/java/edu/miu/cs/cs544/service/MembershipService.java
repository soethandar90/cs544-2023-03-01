package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Membership;

import java.util.List;
import java.util.Optional;

public interface MembershipService {
    public void addOneMembership(Membership membership);
    public void updateOneMembershipByMembershipId(Membership membership);
    public void deleteOneMembershipByMembershipId(int membershipId);
    public Optional<List<Membership>> findAllMembershipsOfOneMemberByMemberId(int memberId);
}
