package com.example.travelagencyproject.services.interfaces;

import com.example.travelagencyproject.models.Location;

import java.util.List;
public interface LocationService {

    List<Location> getAll();

    Location getById(long id);

    Location getByName(String name);

    void create(Location location);

    void update(Location location);

    void delete(int id);
}
