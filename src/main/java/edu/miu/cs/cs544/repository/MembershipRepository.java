package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.model.Location;
import edu.miu.cs.cs544.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Integer> {
    public Membership findAllByMemberId(int memberId);
}
