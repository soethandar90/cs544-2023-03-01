package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.model.BadgeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BadgeTransactionRepository extends JpaRepository<BadgeTransaction, Integer> {

    @Query(value="SELECT COUNT(*) FROM BadgeTransaction WHERE badgeId=:badgeId AND locationId=:locationId and planId =:planId AND transactionType='ALLOWED' AND transactionTime between :start AND :end ", nativeQuery = true)
    public int findCountByDate(@Param("badgeId") int badgeId,
                               @Param("locationId") int locationId,
                               @Param("planId") int planId,
                               @Param("start") String start,
                               @Param("end") String end);

    @Query(value="SELECT DISTINCT * FROM BadgeTransaction bt INNER JOIN Badge b ON bt.badgeId = b.badgeId WHERE b.memberid=:memberid", nativeQuery = true)
    public Optional<List<BadgeTransaction>> findAllTransactionOfOneMemberByMemberId(@Param("memberid") int memberid);

    
}
