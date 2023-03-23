package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Location;

import java.util.List;

public interface LocationService {

    Location findOneLocationByBadgeId(int id);

    List<Location> findAllLocations();

    void addOneLocation(Location location);

    void updateOneLocation(int locationId, Location location);

    List<Location> findAllLocationOfOnePlanByPlanId(int id);


}



