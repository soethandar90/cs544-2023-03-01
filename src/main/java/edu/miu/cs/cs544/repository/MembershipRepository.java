package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Integer> {
    @Query(value="SELECT * FROM memberships WHERE memberId=:memberId", nativeQuery = true)
    public Optional<Membership> findAllMembershipsOfOneMemberByMemberId(@Param("memberId") int memberId);

    @Query(value="SELECT * FROM memberships WHERE membershipId=:membershipId", nativeQuery = true)
    public Membership findOneMembershipsOfOneMemberByMembershipId(@Param("membershipId") int membershipId);
}
