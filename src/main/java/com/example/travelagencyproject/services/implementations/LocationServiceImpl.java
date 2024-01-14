package com.example.travelagencyproject.services.implementations;

import com.example.travelagencyproject.models.Location;
import com.example.travelagencyproject.repositories.interfaces.LocationRepository;
import com.example.travelagencyproject.services.interfaces.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository repository;

    @Autowired
    public LocationServiceImpl(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Location> getAll() {
        return repository.getAll();
    }

    @Override
    public Location getById(long id) {
        return repository.getById(id);
    }

    @Override
    public void create(Location location) {
        repository.create(location);
    }

    @Override
    public void update(Location location) {
        repository.update(location);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
