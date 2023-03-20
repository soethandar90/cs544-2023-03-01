package edu.miu.cs.cs544.service.imp;

import edu.miu.cs.cs544.model.Timeslot;
import edu.miu.cs.cs544.repository.TimeslotRepository;
import edu.miu.cs.cs544.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
