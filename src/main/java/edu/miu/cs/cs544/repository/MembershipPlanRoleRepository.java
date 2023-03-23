package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.model.MembershipPlanRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MembershipPlanRoleRepository extends JpaRepository<MembershipPlanRole, Integer> {

@Query(value = "SELECT * FROM MemberShipPlanRole WHERE usageFrequency='WEEKLY'",nativeQuery = true)
    List<MembershipPlanRole> getPlanByWeekly();
}
