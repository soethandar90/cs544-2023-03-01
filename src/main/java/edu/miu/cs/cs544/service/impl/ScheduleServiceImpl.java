package edu.miu.cs.cs544.service.impl;

import edu.miu.cs.cs544.model.Membership;
import edu.miu.cs.cs544.model.MembershipPlan;
import edu.miu.cs.cs544.model.MembershipPlanRole;
import edu.miu.cs.cs544.repository.MembershipPlanRoleRepository;
import edu.miu.cs.cs544.repository.MembershipRepository;
import edu.miu.cs.cs544.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.coyote.http11.Constants.a;

@Service
public class ScheduleServiceImpl implements SchedulerService {
    @Autowired
    MembershipPlanRoleRepository membershipPlanRoleRepository;
    @Autowired
    MembershipRepository  membershipRepository;
    @Override
    @Scheduled(cron="0 59 23 ? * MON")
    public void runWeeklySchedule() {
        List<MembershipPlanRole> membershipPlanRoleList = membershipPlanRoleRepository.getPlanByWeekly();
        membershipPlanRoleList.forEach(
                membershipPlanRole -> {

                  List<Membership> membershipList =  membershipRepository.updateUsage(membershipPlanRole.getMembershipPlan().getPlanId(),membershipPlanRole.getRole().getRoleId()).get();
                    membershipList.forEach(
                            membership -> {
                                membership.setCurrentUsage(membershipPlanRole.getUsageLimit());
                                membershipRepository.save(membership);
                            }
                    );
                }
        );
    }

    @Override
    public void runMonthlySchedule() {

    }
}
