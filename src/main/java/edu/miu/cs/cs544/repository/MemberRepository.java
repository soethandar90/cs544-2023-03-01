package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findByEmail(String email);
}
