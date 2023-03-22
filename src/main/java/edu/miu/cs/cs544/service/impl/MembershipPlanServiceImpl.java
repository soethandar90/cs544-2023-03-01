package edu.miu.cs.cs544.service.impl;

import edu.miu.cs.cs544.model.Location;
import edu.miu.cs.cs544.model.MembershipPlan;
import edu.miu.cs.cs544.repository.LocationRepository;
import edu.miu.cs.cs544.repository.MembershipPlanRepository;
import edu.miu.cs.cs544.service.MembershipPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MembershipPlanServiceImpl implements MembershipPlanService {
    @Autowired
   private MembershipPlanRepository membershipPlanRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public void addOnePlan(MembershipPlan membershipPlan) {
         membershipPlanRepository.save(membershipPlan);
    }

    @Override
    public void updateOnePlanByPlanId(MembershipPlan membershipPlan) {
        membershipPlanRepository.save(membershipPlan);
    }

    @Override
    public void deleteOnePlan(int planId) {
        membershipPlanRepository.deleteById(planId);
    }

    @Override
    public List<MembershipPlan> findAllMembershipPlanOfmemberByMemberId(int id) {
        return null;
    }

    //@Override
    public List<MembershipPlan> findAllMembershipPlanOfmemberByMemberId() {
        return membershipPlanRepository.findAll();
    }

    @Override
    public Optional<MembershipPlan> getMembershipPlanById(int id) {
      return  membershipPlanRepository.findById(id);
    }

    @Override
    public List<Location> findLocationByPlan(Integer planid) {
        return locationRepository.findLocationByPlan(planid);
    }
}



