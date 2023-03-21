package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.model.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeslotRepository extends JpaRepository<Timeslot, Integer> {

}
