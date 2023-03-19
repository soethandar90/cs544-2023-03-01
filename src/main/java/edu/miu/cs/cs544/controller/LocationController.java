package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.model.Location;
import edu.miu.cs.cs544.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/id/{id}")
    public Location getLocationById(int id) {
        return locationService.getLocationById(id);
    }

    @GetMapping("/list")
    public List<Location> getLocationList() {
        return locationService.getAllLocations();
    }
    @PostMapping("/add")
    public void addLocation(Location location) {
        locationService.addLocation(location);
    }

    @PutMapping("/update")
    public void updateLocation(Location location) {
        locationService.updateLocation(location);
    }

}
