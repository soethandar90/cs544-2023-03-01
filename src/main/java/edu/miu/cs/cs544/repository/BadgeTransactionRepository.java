package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.model.Badge;
import edu.miu.cs.cs544.model.BadgeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeTransactionRepository extends JpaRepository<BadgeTransaction, Integer> {
    @Query(value="SELECT COUNT(*) FROM BadgeTransaction WHERE badgeId=:badgeId AND locationId=:locationId and planId =:planId AND transactionType='ALLOWED' AND transactionTime between :start AND :end ", nativeQuery = true)
    public int findCountByDate(@Param("badgeId") int badgeId,
                        @Param("locationId") int locationId,
                        @Param("planId") int planId,
                        @Param("start") String start,
                        @Param("end") String end);
}
