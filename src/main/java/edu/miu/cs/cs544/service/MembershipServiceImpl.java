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
    public Membership updateOneMembershipByMembershipId(int memberId, Membership membership) {

        Optional<Membership> optionalMembership = membershipRepository.findById(memberId);
        if (!optionalMembership.isPresent()) {
            System.err.println("Membership not found with id " + memberId);
        }
        Membership existingMembership = optionalMembership.get();

        // Update the existing location with the new data
        if(membership.getStartDate()!=null){
            existingMembership.setStartDate(membership.getStartDate());
        }

        if(membership.getEndDate()!=null){
            existingMembership.setEndDate(membership.getEndDate());
        }

        if(membership.getType()!=null){
            existingMembership.setType(membership.getType());
        }

        if(membership.getCurrentUsage()>0){
            existingMembership.setCurrentUsage(membership.getCurrentUsage());
        }
        if(membership.getPlan()!=null){
            existingMembership.setPlan(membership.getPlan());
        }
        return membershipRepository.save(existingMembership);
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
