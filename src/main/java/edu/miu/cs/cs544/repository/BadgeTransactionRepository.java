package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.model.Badge;
import edu.miu.cs.cs544.model.BadgeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeTransactionRepository extends JpaRepository<BadgeTransaction, Integer> {

}
