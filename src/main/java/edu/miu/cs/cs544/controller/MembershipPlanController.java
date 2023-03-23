package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.model.Location;
import edu.miu.cs.cs544.model.MembershipPlan;
import edu.miu.cs.cs544.service.LocationService;
import edu.miu.cs.cs544.service.MembershipPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")
public class MembershipPlanController {


    @Autowired
    private MembershipPlanService membershipPlanService;
    @Autowired
    private LocationService locationService;

    @GetMapping("/{id}")
    public List<MembershipPlan> findAll(@PathVariable int id) {
        return membershipPlanService.findAllMembershipPlanOfMemberByMemberId(id);
    }

    @PostMapping
    public MembershipPlan addOnePlan(@RequestBody MembershipPlan membershipPlan) {
        return membershipPlanService.addOnePlan(membershipPlan);
    }

    @PutMapping("/{id}")
    public MembershipPlan updateOnePlan(@PathVariable Integer id, @RequestBody MembershipPlan membershipPlan) {
        return membershipPlanService.updateOnePlanByPlanId(membershipPlan);
    }

    @DeleteMapping("/{id}")
    public void deleteOnePlan(@PathVariable int id) {
        membershipPlanService.deleteOnePlan(id);
    }

    @GetMapping("/{planid}/locations")
    public List<Location> getAllLocationOfPlanByPlanId(@PathVariable int planid) {
        return locationService.findAllLocationOfOnePlanByPlanId(planid);
    }
}
