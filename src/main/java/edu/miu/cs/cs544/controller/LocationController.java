package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.model.Location;
import edu.miu.cs.cs544.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/{id}")
    public Location findOneLocationById(@PathVariable int id) {
        return locationService.findOneLocationByBadgeId(id);
    }

    @GetMapping
    public List<Location> findLocationList() {
        return locationService.findAllLocations();
    }
    @PostMapping
    public void addOneLocation(@RequestBody Location location) {
        locationService.addOneLocation(location);
    }

    @PutMapping
    public void updateOneLocation(@PathVariable int locationId, @RequestBody Location location) {
        locationService.updateOneLocation(locationId, location);
    }

//    @GetMapping("/{id}")
//    public List<Location> findAllLocationOfOnePlanByPlanId(int planId){
//        return locationService.findAllLocationOfOnePlanByPlanId(planId);
//
//    }

}
