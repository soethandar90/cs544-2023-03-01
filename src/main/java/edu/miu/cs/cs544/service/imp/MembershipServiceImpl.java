package edu.miu.cs.cs544.service.imp;

import edu.miu.cs.cs544.model.Membership;
import edu.miu.cs.cs544.repository.MembershipRepository;
import edu.miu.cs.cs544.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MembershipServiceImpl implements MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    @Override
    public void addOneMembership(Membership membership) {
        membershipRepository.save(membership);
    }

    @Override
    public void updateOneMembershipByMembershipId(Membership membership) {
        membershipRepository.save(membership);
    }

    @Override
    public void deleteOneMembershipByMembershipId(int membershipId) {
        membershipRepository.deleteById(membershipId);
    }

    @Override
    public Optional<Membership> findAllMembershipsOfOneMemberByMemberId(int memberId) {
       return membershipRepository.findAllMembershipsOfOneMemberByMemberId(memberId);
    }
}
