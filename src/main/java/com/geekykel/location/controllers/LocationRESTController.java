package com.geekykel.location.controllers;

import com.geekykel.location.entities.Location;
import com.geekykel.location.repos.LocationRespository;
import com.geekykel.location.service.LocationService;
import com.geekykel.location.utils.EmailUtil;
import com.geekykel.location.utils.ReportUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.ServletContext;

/**
 * Created by GeekyKel on 5/21/2019
 */

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

    @Autowired
    LocationRespository locationRespository;

    @GetMapping
    public List<Location> getLocations() {
        return locationRespository.findAll();
    }

    
    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationRespository.save(location);
    }
    
    @PutMapping
    public Location updateLocation(@RequestBody Location location) {
        return locationRespository.save(location);
    }
    
    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable("id") int id) {
        locationRespository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Location getLocation(@PathVariable("id") int id) {
        return locationRespository.findById(id).get();
    }



}
