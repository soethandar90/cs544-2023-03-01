package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query(value = "SELECT * FROM Location  WHERE planId = :planId", nativeQuery = true)
    List<Location> findLocationByPlan(Integer planId);

    @Query(value = "SELECT * FROM Location WHERE planId = :id", nativeQuery = true)
    List<Location> findLocationsOfOnePlanByPlanId(int id);


}
