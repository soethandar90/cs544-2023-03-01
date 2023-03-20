package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Membership;
import edu.miu.cs.cs544.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public interface MembershipService {
    public void addOneMembership(Membership membership);
    public void updateOneMembershipByMembershipId(Membership membership);
    public void deleteOneMembershipByMembershipId(int membershipId);
    public Optional<Membership> findAllMembershipsOfOneMemberByMemberId(int memberId);
}
