package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.model.Location;
import edu.miu.cs.cs544.model.MembershipPlan;
import edu.miu.cs.cs544.service.LocationService;
import edu.miu.cs.cs544.service.MembershipPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/membershipPlans")
public class MembershipPlanController {


    @Autowired
    private MembershipPlanService membershipPlanService;

    @GetMapping
    public List<MembershipPlan> findAll(int id) {
        return membershipPlanService.findAllMembershipPlanOfmemberByMemberId(id);
    }

    @PostMapping
    public void addOnePlan(@RequestBody MembershipPlan membershipPlan) {
        membershipPlanService.addOnePlan(membershipPlan);
    }

    @PutMapping("/{id}")
    public void updateOnePlan(@PathVariable Integer id,@RequestBody MembershipPlan membershipPlan) {
        //membershipPlanService.updateOnePlanByPlanId(membershipPlan);
    membershipPlanService.updateOnePlanByPlanId(membershipPlan);

    }

    @DeleteMapping("/{id}")
    public void deleteOnePlan(@PathVariable int id) {
        membershipPlanService.deleteOnePlan(id);
    }


//
//
}
