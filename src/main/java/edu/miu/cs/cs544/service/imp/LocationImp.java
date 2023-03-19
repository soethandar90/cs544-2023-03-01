package edu.miu.cs.cs544.service.imp;

import edu.miu.cs.cs544.model.Location;
import edu.miu.cs.cs544.repository.LocationRepository;
import edu.miu.cs.cs544.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LocationImp implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location getLocationById(int id) {
        return locationRepository.findById(id).get();
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public void addLocation(Location location) {
        locationRepository.save(location);
    }
    @Override
    public void updateLocation(Location location) {
        locationRepository.save(location);
    }

}
