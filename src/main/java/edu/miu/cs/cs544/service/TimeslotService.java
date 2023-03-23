package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Timeslot;

import java.util.List;

public interface TimeslotService {
    Timeslot addOneTimeslot(Timeslot timeslot);

    Timeslot updateOneTimeslotByTimeslotId(Timeslot timeslot);

    String deleteOneTimeslotByTimeslotId(Integer id);

    List<Timeslot> findAll();
}
