package com.example.APIFlightApp.controllers;


import com.example.APIFlightApp.repositories.HistoricPlaneRepository;
import com.example.APIFlightApp.services.HistoricPlaneService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoricPlaneController {

    @Autowired
    HistoricPlaneService historicPlaneService;

    @Autowired
    public HistoricPlaneController(HistoricPlaneService historicPlaneService){
        this.historicPlaneService = historicPlaneService;
    }

    @RequestMapping(path = "/historic")
    public String getAllHistoricPlane(){
        JSONArray jsonData = new JSONArray(historicPlaneService.getAllHistoricFlights());
        return jsonData.toString();
    }

    @RequestMapping(path = "/historic/{id}")
    public String getHistoricPlaneById(@PathVariable("id") String id){
        JSONObject jsonObject = new JSONObject(historicPlaneService.getHistoricFlightById(id));
        return jsonObject.toString();
    }
}
