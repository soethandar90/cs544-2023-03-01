package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.model.MembershipPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipPlanRepository extends JpaRepository<MembershipPlan, Integer> {
    @Query(value = "Select * from membership m inner join membershipplan mp on mp.planid = m.plan_planId where m.memberid = memberId", nativeQuery = true)
    List<MembershipPlan> findAllMembershipPlanOfmemberByMemberId(@Param("memberId") int memberId);
}
