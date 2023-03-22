package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.model.Membership;
import edu.miu.cs.cs544.model.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TimeslotRepository extends JpaRepository<Timeslot, Integer> {

    @Query(value="SELECT * FROM timeslot WHERE locationId=:locationId AND dayOfWeek=:day", nativeQuery = true)
    public Optional<Timeslot> findTimeslotByLocationIdAndDay(@Param("day") String day, @Param("locationId") int locationId);
}
