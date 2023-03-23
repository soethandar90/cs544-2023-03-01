package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Membership;
import edu.miu.cs.cs544.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MembershipServiceImpl implements MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    @Override
    public Membership addOneMembership(Membership membership) {
        return membershipRepository.save(membership);
    }

    @Override
    public Membership updateOneMembershipByMembershipId(Integer memberId, Membership membership) {

        Optional<Membership> optionalMembership = membershipRepository.findById(memberId);
        if (!optionalMembership.isPresent()) {
            System.err.println("Membership not found with id " + memberId);
        }
        Membership existingMemebership = optionalMembership.get();

        // Update the existing location with the new data

        existingMemebership.setType(membership.getType());
        existingMemebership.setPlan(membership.getPlan());
        existingMemebership.setStartDate(membership.getStartDate());
        existingMemebership.setEndDate(membership.getEndDate());

        return membershipRepository.save(existingMemebership);

    }

    @Override
    public void deleteOneMembershipByMembershipId(int membershipId) {
        membershipRepository.deleteById(membershipId);
    }

    @Override
    public Optional<List<Membership>> findAllMembershipsOfOneMemberByMemberId(int memberId) {
        return membershipRepository.findAllMembershipsOfOneMemberByMemberId(memberId);
    }
}
