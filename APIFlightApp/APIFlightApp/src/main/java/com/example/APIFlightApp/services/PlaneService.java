package com.example.APIFlightApp.services;


import com.example.APIFlightApp.models.Plane;
import com.example.APIFlightApp.repositories.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService {

    PlaneRepository planeRepository;

    @Autowired
    public PlaneService(PlaneRepository planeRepository){
        this.planeRepository = planeRepository;
    }

    public List<Plane> getAllPlanes(){
        return planeRepository.findAll();
    }
    
    public Plane getPlaneById(String id){
        return planeRepository.findById(id).get();
    }
}
