package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.MembershipPlan;

import java.util.List;
import java.util.Optional;

public interface MembershipPlanService {


    public void addOnePlan(MembershipPlan membershipPlan);
    public void updateOnePlanByPlanId(MembershipPlan membershipPlan);
    public void deleteOnePlan(int planId);
    public List <MembershipPlan> findAllMembershipPlanOfmemberByMemberId();

public Optional<MembershipPlan> getMembershipPlanById(int id);

}
