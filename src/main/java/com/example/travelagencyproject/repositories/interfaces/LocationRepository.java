package com.example.travelagencyproject.repositories.interfaces;

import com.example.travelagencyproject.models.Location;

import java.util.List;
public interface LocationRepository {
    List<Location> getAll();

    Location getById(long id);

    Location getByName(String name);
    void create(Location location);

    void update(Location location);

    void delete(int id);
}
