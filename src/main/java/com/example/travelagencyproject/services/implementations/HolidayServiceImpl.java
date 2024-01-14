package com.example.travelagencyproject.services.implementations;

import com.example.travelagencyproject.models.Holiday;
import com.example.travelagencyproject.repositories.interfaces.HolidayRepository;
import com.example.travelagencyproject.services.interfaces.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HolidayServiceImpl implements HolidayService {
    private final HolidayRepository repository;

    @Autowired
    public HolidayServiceImpl(HolidayRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Holiday> getAll(Optional<String> location, Optional<Date> startDate, Optional<Integer> duration) {
        return repository.getAll(location, startDate, duration);
    }

    @Override
    public Holiday getById(long id) {
        return repository.getById(id);
    }

    @Override
    public void create(Holiday holiday) {
        repository.create(holiday);
    }

    @Override
    public void update(Holiday holiday) {
        repository.update(holiday);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
