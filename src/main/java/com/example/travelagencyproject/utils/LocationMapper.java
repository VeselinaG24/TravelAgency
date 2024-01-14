package com.example.travelagencyproject.utils;

import com.example.travelagencyproject.models.Location;
import com.example.travelagencyproject.models.dtos.CreateLocationDTO;
import com.example.travelagencyproject.models.dtos.UpdateLocationDTO;
import com.example.travelagencyproject.models.dtos.responses.ResponseLocationDTO;
import com.example.travelagencyproject.repositories.interfaces.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {
    private final LocationRepository locationRepository;

    @Autowired
    public LocationMapper(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location fromDto(CreateLocationDTO locationDTO) {
        Location location = new Location();
        location.setCity(locationDTO.getCity());
        location.setCountry(locationDTO.getCountry());
        location.setNumber(locationDTO.getNumber());
        location.setStreet(locationDTO.getStreet());
        location.setImageUrl(locationDTO.getImageUrl());
        return location;
    }
    public Location fromDto(UpdateLocationDTO locationDTO) {
        Location location = locationRepository.getById(locationDTO.getId());
        location.setCity(locationDTO.getCity());
        location.setCountry(locationDTO.getCountry());
        location.setNumber(locationDTO.getNumber());
        location.setStreet(locationDTO.getStreet());
        location.setImageUrl(locationDTO.getImageUrl());
        return location;
    }

    public ResponseLocationDTO toDto(Location location){
        ResponseLocationDTO locationDTO = new ResponseLocationDTO();
        locationDTO.setId(location.getId());
        locationDTO.setCity(location.getCity());
        locationDTO.setCountry(location.getCountry());
        locationDTO.setNumber(location.getNumber());
        locationDTO.setStreet(location.getStreet());
        locationDTO.setImageUrl(location.getImageUrl());
        return locationDTO;
    }


}
