package com.geekykel.location.controllers;

import com.geekykel.location.entities.Location;
import com.geekykel.location.repos.LocationRespository;
import com.geekykel.location.service.LocationService;
import com.geekykel.location.utils.EmailUtil;
import com.geekykel.location.utils.ReportUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.servlet.ServletContext;

/**
 * Created by GeekyKel on 5/21/2019
 */
@Controller
public class LocationController {

    @Autowired
    LocationService service;
    
//    @Autowired
//    LocationRespository locationRespository;
    
    @Autowired
    EmailUtil emailUtil;
    
    @Autowired
    ReportUtil reportUtil;
    
    @Autowired
    ServletContext servletContext;

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createLocation";
    }

    @RequestMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
        Location locationsaved = service.saveLocation(location);
        String msg = "Location saved with id: " + locationsaved.getId();
        String message = "Location Successfully saved";
        modelMap.addAttribute("msg", msg);
        modelMap.addAttribute("message", message);
        emailUtil.sendEmail("springabcxyz@gmail.com", "Location Saved", "Location saved successfully and returning back");
        return "createLocation";
    }

    @RequestMapping("/displayLocations")
    public String displayLocations(ModelMap modelMap) {
        List<Location> locations = service.getAllLocation();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/deleteLocation")
    public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
        Location location = service.getLocationById(id);
        String msg = "Location with id: " + location.getId() + " has been deleted";
        service.deleteLocation(location);
        modelMap.addAttribute("locationDeleted", msg);
        List<Location> locations = service.getAllLocation();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }
    
    @RequestMapping("/editLocation")
    public String editLocation(@RequestParam("id") int id, ModelMap modelMap) {
        Location location = service.getLocationById(id);
        modelMap.addAttribute("location", location);
        return "updateLocation";
    }
    
    @RequestMapping("/updateLoc")
    public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
        service.updateLocation(location);
        List<Location> locations = service.getAllLocation();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }
    
    @RequestMapping("/generateReport")
    public String generateReport() {
    	String path = servletContext.getRealPath("/");
    	//List<Object[]> data = locationRespository.findTypeAndTypeCount();
    	//reportUtil.generatePieChart(path, data);
        return "report";
    }
    


}
