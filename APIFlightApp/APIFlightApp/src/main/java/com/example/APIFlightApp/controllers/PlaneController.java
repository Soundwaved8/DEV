package com.example.APIFlightApp.controllers;


import com.example.APIFlightApp.repositories.PlaneRepository;
import com.example.APIFlightApp.services.PlaneService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaneController {

    @Autowired
    PlaneService planeService;

    @Autowired
    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @RequestMapping(path = "/planes")
    public String getAllPlanes() {
        JSONArray jsonData = new JSONArray(planeService.getAllPlanes());
        return jsonData.toString();
    }

    @RequestMapping(path = "/planes/{id}")
    public String getPlaneById(@PathVariable("id") String id) {
        JSONObject jsonObject = new JSONObject(planeService.getPlaneById(id));
        return jsonObject.toString();
    }


}
