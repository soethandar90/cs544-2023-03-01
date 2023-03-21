package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Timeslot;

import java.util.List;

public interface TimeslotService {
    public Timeslot addOneTimeslot(Timeslot timeslot);
    public Timeslot updateOneTimeslotByTimeslotId(Timeslot timeslot);
    public String deleteOneTimeslotByTimeslotId(Integer id);

   public List<Timeslot> findAll();
}
