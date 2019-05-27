package com.geekykel.location.service;

import com.geekykel.location.entities.Location;

import java.util.List;

/**
 * Created by GeekyKel on 5/21/2019
 */
public interface LocationService {

    Location saveLocation(Location location);
    Location updateLocation(Location location);
    void deleteLocation(Location location);
    Location getLocationById(int id);
    List<Location> getAllLocation();
}
