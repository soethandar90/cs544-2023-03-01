package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.model.Address;
import edu.miu.cs.cs544.model.Location;
import edu.miu.cs.cs544.model.Membership;
import edu.miu.cs.cs544.service.LocationService;
import edu.miu.cs.cs544.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memberships")
public class MembershipController {
    //addOneMembership
    //updateOneMembershipByMembershipId(membershipId)
    //deleteOneMembershipByMembershipId(membershipId)
    //findAllMembershipsOfOneMemberByMemberId(memberId)

    @Autowired
    private MembershipService membershipService;

    @PostMapping
    public void addOneMembership(@RequestBody Membership membership) {
        membershipService.addOneMembership(membership);
    }

    @PutMapping
    public void updateOneMembershipByMembershipId(@RequestBody Membership membership){
        membershipService.updateOneMembershipByMembershipId(membership);
    }

    @DeleteMapping
    public void deleteOneMembershipByMembershipId(@PathVariable Membership membership){
        membershipService.updateOneMembershipByMembershipId(membership);
    }


}
