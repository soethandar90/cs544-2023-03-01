package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.model.Badge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgeRepository extends JpaRepository<Badge,Integer> {
}
