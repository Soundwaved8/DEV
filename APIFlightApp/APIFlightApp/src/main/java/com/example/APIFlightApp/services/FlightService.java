package com.example.APIFlightApp.services;


import com.example.APIFlightApp.models.Flight;
import com.example.APIFlightApp.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }
    
    public Flight getFlightById(String id){
        return flightRepository.findById(id).get();
    }
}
