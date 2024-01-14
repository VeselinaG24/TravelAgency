package com.example.travelagencyproject.controllers;

import java.util.List;

import com.example.travelagencyproject.models.Location;
import com.example.travelagencyproject.models.dtos.CreateLocationDTO;
import com.example.travelagencyproject.models.dtos.UpdateLocationDTO;
import com.example.travelagencyproject.models.dtos.responses.ResponseLocationDTO;
import com.example.travelagencyproject.services.interfaces.LocationService;
import com.example.travelagencyproject.utils.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
public class LocationController {


    private final LocationService service;
    private final LocationMapper locationMapper;
    @Autowired
    public LocationController(LocationService service, LocationMapper locationMapper) {
        this.service = service;
        this.locationMapper=locationMapper;
    }
    @GetMapping("/{locationId}")
    public ResponseEntity<ResponseLocationDTO> getLocationById(@PathVariable int locationId) {
        try {
            Location location = service.getById(locationId);
            return new ResponseEntity<>(locationMapper.toDto(location), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        return new ResponseEntity<>( service.getAll(), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<ResponseLocationDTO> update(@RequestBody UpdateLocationDTO locationDTO) {
        try {
            Location location = locationMapper.fromDto(locationDTO);
            service.update(location);
            return new ResponseEntity<>(locationMapper.toDto(location), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping()
    public ResponseEntity<ResponseLocationDTO> create(@RequestBody CreateLocationDTO locationDTO){
        try {
            Location location = locationMapper.fromDto(locationDTO);
            service.create(location);
            return new ResponseEntity<>(locationMapper.toDto(location), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity<Boolean> delete(@PathVariable int locationId) {
        try {
            service.delete(locationId);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
