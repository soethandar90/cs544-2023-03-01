package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.contract.LocationDTO;
import edu.miu.cs.cs544.model.Location;

import java.util.List;

public interface LocationService {

    LocationDTO findOneLocationByBadgeId(int id);

    List<LocationDTO> findAllLocations();

    Location addOneLocation(Location location);

    Location updateOneLocation(int locationId, Location location);

    List<Location> findAllLocationOfOnePlanByPlanId(int id);

    void deleteOneLocationByLocationId(int id);
}



