package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
