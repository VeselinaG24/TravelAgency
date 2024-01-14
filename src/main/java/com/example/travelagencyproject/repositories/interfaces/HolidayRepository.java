package com.example.travelagencyproject.repositories.interfaces;

import com.example.travelagencyproject.models.Holiday;

import java.util.List;
import java.util.Optional;

public interface HolidayRepository {
    List<Holiday> getAll(Optional<String> location, Optional<String> startDate, Optional<Integer> duration);

    Holiday getById(long id);

    void create(Holiday holiday);

    void update(Holiday holiday);

    void delete(int id);
}
