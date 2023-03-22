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
    @Query(value="SELECT * FROM membership WHERE memberId=:memberId", nativeQuery = true)
    public Optional<List<Membership>> findAllMembershipsOfOneMemberByMemberId(@Param("memberId") int memberId);

    @Query(value="SELECT * FROM membership WHERE membershipId=:membershipId", nativeQuery = true)
    public Membership findOneMembershipsOfOneMemberByMembershipId(@Param("membershipId") int membershipId);
    @Query(value="SELECT * FROM membership WHERE plan_planId=:planId AND memberId=:memberid", nativeQuery = true)
    public Membership
    findOneMembershipsOfOneMemberByMembershipId2(@Param("planId") int membershipPlanId,@Param("memberid") int memberId);


}
