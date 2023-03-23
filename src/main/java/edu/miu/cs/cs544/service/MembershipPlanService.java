package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Location;
import edu.miu.cs.cs544.model.MembershipPlan;

import java.util.List;
import java.util.Optional;

public interface MembershipPlanService {


    MembershipPlan addOnePlan(MembershipPlan membershipPlan);

    MembershipPlan updateOnePlanByPlanId(MembershipPlan membershipPlan);

    void deleteOnePlan(int planId);

    List<MembershipPlan> findAllMembershipPlanOfMemberByMemberId(int id);

    Optional<MembershipPlan> getMembershipPlanById(int id);

    List<Location> findLocationByPlan(Integer planid);
}
