package edu.miu.cs.cs544.service.imp;

import edu.miu.cs.cs544.model.Location;
import edu.miu.cs.cs544.repository.LocationRepository;
import edu.miu.cs.cs544.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location findOneLocationByBadgeId(int id) {
        return locationRepository.findById(id).get();
    }

    @Override
    public List<Location> findAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public void addOneLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public void updateOneLocation(int locationId, Location location) {
            Optional<Location> optionalLocation = locationRepository.findById(locationId);
            if (!optionalLocation.isPresent()) {
                System.out.println("Location not found with id " + locationId);
            }
            Location existingLocation = optionalLocation.get();

            // Update the existing location with the new data
            existingLocation.setLocationName(location.getLocationName());
            existingLocation.setDescription(location.getDescription());
            existingLocation.setLocationType(location.getLocationType());
            existingLocation.setCapacity(location.getCapacity());
            existingLocation.setTimeSlots(location.getTimeSlots());
            existingLocation.setPlan(location.getPlan());

            // Save the updated location to the database
             locationRepository.save(existingLocation);
        System.out.println("Location updated");
    }

//    @Override
//    public List<Location> findAllLocationOfOnePlanByPlanId(int id) {
//       return locationRepository.findLocationsOfOnePlanByPlanId(id);
//    }


    }



