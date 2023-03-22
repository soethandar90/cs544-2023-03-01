package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.model.Badge;
import edu.miu.cs.cs544.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BadgeRepository extends JpaRepository<Badge,Integer> {
    @Query(value="SELECT * FROM badge WHERE memberId=:memberId", nativeQuery = true)
    Optional<List<Badge>> findAllByMemberId(@Param("memberId") int memberId);


    @Query(value="SELECT * FROM badge WHERE badgeCode=:badge", nativeQuery = true)
    Optional<Badge> findByBadge(@Param("badge") String badge);

    Badge findCurrentBadgeById(int id);
}
