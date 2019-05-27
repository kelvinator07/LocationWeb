package com.geekykel.location.service;

import com.geekykel.location.entities.Location;
import com.geekykel.location.repos.LocationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GeekyKel on 5/21/2019
 */
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRespository locationRespository;

    @Override
    public Location saveLocation(Location location) {
        return locationRespository.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRespository.save(location);
    }

    @Override
    public void deleteLocation(Location location) {
        locationRespository.delete(location);
    }

    @Override
    public Location getLocationById(int id) {
        return locationRespository.findById(id).get();
    }

    @Override
    public List<Location> getAllLocation() {
        return locationRespository.findAll();
    }

    public LocationRespository getLocationRespository() {
        return locationRespository;
    }

    public void setLocationRespository(LocationRespository locationRespository) {
        this.locationRespository = locationRespository;
    }
}
