package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Location;

import java.util.List;

public interface LocationService {

    public Location getLocationById(int id);

    public List<Location> getAllLocations();

    public void addLocation(Location location);

    public void updateLocation(Location location);



}



