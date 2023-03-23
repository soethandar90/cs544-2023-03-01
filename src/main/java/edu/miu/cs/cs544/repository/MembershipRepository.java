package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Integer> {
    @Query(value = "SELECT * FROM membership WHERE memberId=:memberId", nativeQuery = true)
    Optional<List<Membership>> findAllMembershipsOfOneMemberByMemberId(@Param("memberId") int memberId);

    @Query(value = "SELECT * FROM membership WHERE membershipId=:membershipId", nativeQuery = true)
    Membership findOneMembershipsOfOneMemberByMembershipId(@Param("membershipId") int membershipId);

    @Query(value = "SELECT * FROM membership WHERE plan_planId=:planId AND memberId=:memberid", nativeQuery = true)
    Membership findOneMembershipsOfOneMemberByMembershipId2(@Param("planId") int membershipPlanId, @Param("memberid") int memberId);

    @Query(value = "SELECT COUNT(*) FROM membership WHERE plan_planId=:planId AND memberId=:memberid AND membershipType='UNLIMITED'", nativeQuery = true)
    int searchIfUnlimitedMembership(@Param("memberid") int memberId, @Param("planId") int planId);
}