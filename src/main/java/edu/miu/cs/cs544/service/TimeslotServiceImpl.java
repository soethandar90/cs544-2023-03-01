package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Timeslot;
import edu.miu.cs.cs544.repository.TimeslotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeslotServiceImpl implements TimeslotService {
    @Autowired
    TimeslotRepository timeslotRepository;

    @Override
    public Timeslot addOneTimeslot(Timeslot timeslot) {
        timeslotRepository.save(timeslot);
        return timeslot;
    }

    @Override
    public Timeslot updateOneTimeslotByTimeslotId(Timeslot timeslot) {
        timeslotRepository.save(timeslot);
        return timeslot;
    }

    @Override
    public String deleteOneTimeslotByTimeslotId(Integer id) {
        timeslotRepository.deleteById(id);
        return "200";
    }

    @Override
    public List<Timeslot> findAll() {
        return timeslotRepository.findAll();
    }

}
