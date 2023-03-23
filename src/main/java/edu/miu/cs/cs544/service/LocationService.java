package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Location;

import java.util.List;

public interface LocationService {

    public Location findOneLocationByBadgeId(int id);

    public List<Location> findAllLocations();

    public void addOneLocation(Location location);

    public void updateOneLocation(int locationId, Location location);

    public List<Location> findAllLocationOfOnePlanByPlanId(int id);


}



