package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.model.Badge;
import edu.miu.cs.cs544.model.BadgeTransaction;
import edu.miu.cs.cs544.model.Location;
import edu.miu.cs.cs544.model.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BadgeTransactionRepository extends JpaRepository<BadgeTransaction, Integer> {

    @Query(value="SELECT DISTINCT * FROM BadgeTransaction bt INNER JOIN Badge b ON bt.badgeId = b.badgeId WHERE b.memberid=:memberid", nativeQuery = true)
    public Optional<List<BadgeTransaction>> findAllTransactionOfOneMemberByMemberId(@Param("memberid") int memberid);
}
