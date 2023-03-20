package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.model.Membership;
import edu.miu.cs.cs544.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/memberships")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @PostMapping
    public void addOneMembership(@RequestBody Membership membership) {
        membershipService.addOneMembership(membership);
    }

    @PutMapping("/{membershipId}")
    public void updateOneMembershipByMembershipId(@RequestBody Membership membership) {
        membershipService.updateOneMembershipByMembershipId(membership);
    }

    @DeleteMapping("/{membershipId}")
    public void deleteOneMembershipByMembershipId(@PathVariable int membershipId) {
        membershipService.deleteOneMembershipByMembershipId(membershipId);
    }

    @GetMapping("/{memberId}")
    public Optional<Membership> findAllMembershipsOfOneMemberByMemberId(@PathVariable int memberId) {
        return membershipService.findAllMembershipsOfOneMemberByMemberId(memberId);
    }
}
