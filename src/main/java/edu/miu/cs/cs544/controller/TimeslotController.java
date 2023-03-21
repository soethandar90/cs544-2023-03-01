package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.model.Role;
import edu.miu.cs.cs544.model.Timeslot;
import edu.miu.cs.cs544.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timeslots")
public class TimeslotController {
    @Autowired
    TimeslotService timeslotService;

    @PostMapping("")
    public Timeslot addOneTimeslot(@RequestBody Timeslot timeslot) {
       Timeslot timeslot1= timeslotService.addOneTimeslot(timeslot);

        return timeslot1;
    }
    @PutMapping("/{id}")
    public Timeslot updateOneTimeslotByTimeslotId(@PathVariable Integer id,@RequestBody Timeslot timeslot) {
        Timeslot timeslot1 = timeslotService.updateOneTimeslotByTimeslotId(timeslot);

        return timeslot1;
    }
    @DeleteMapping("/{id}")
    public String deleteOneTimeslotBYTimeslotId(@PathVariable Integer id){
        return timeslotService.deleteOneTimeslotByTimeslotId(id);
    }

    @GetMapping()
    public List<Timeslot> getAllTimeslotId(){
        return timeslotService.findAll();
    }

}
