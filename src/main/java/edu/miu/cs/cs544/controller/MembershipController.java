package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.model.Membership;
import edu.miu.cs.cs544.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/memberships")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @PostMapping
    public Membership addOneMembership(@RequestBody Membership membership) {
        return membershipService.addOneMembership(membership);
    }

    @PutMapping("/{membershipId}")
    public Membership updateOneMembershipByMembershipId(@PathVariable int membershipId, @RequestBody Membership membership) {
        return membershipService.updateOneMembershipByMembershipId(membershipId,membership);
    }

    @DeleteMapping("/{membershipId}")
    public void deleteOneMembershipByMembershipId(@PathVariable int membershipId) {
        membershipService.deleteOneMembershipByMembershipId(membershipId);
    }

    @GetMapping("/{memberId}")
    public Optional<List<Membership>> findAllMembershipsOfOneMemberByMemberId(@PathVariable int memberId) {
        return membershipService.findAllMembershipsOfOneMemberByMemberId(memberId);
    }
}
