package com.example.APIFlightApp.controllers;


import com.example.APIFlightApp.services.FlightService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController  {

    @Autowired
    FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService){
        this.flightService = flightService;
    }
    @RequestMapping(path = "/flights")
    public String getFlight(){
        JSONArray jsonData = new JSONArray(flightService.getAllFlights());
        return jsonData.toString();
    }

    @RequestMapping(path = "/flights/{id}")
    public String getFlightById(@PathVariable("id") String id){
        JSONObject jsonObject = new JSONObject(flightService.getFlightById(id));
        return jsonObject.toString();
    }
}
