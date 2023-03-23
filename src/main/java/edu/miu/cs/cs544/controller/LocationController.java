package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.contract.LocationDTO;
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
    public LocationDTO findOneLocationById(@PathVariable int id) {
        return locationService.findOneLocationByBadgeId(id);
    }

    @GetMapping
    public List<LocationDTO> findLocationList() {
        return locationService.findAllLocations();
    }

    @PostMapping
    public Location addOneLocation(@RequestBody Location location) {
        return locationService.addOneLocation(location);
    }

    @PutMapping
    public Location updateOneLocation(@PathVariable int locationId, @RequestBody Location location) {
        return locationService.updateOneLocation(locationId, location);
    }

    @DeleteMapping("/{id}")
    public void deleteOneLocationByLocationId(@PathVariable int id) {
        locationService.deleteOneLocationByLocationId(id);
    }
}
