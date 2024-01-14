package com.example.travelagencyproject.services.interfaces;

import com.example.travelagencyproject.models.Holiday;

import java.util.List;
import java.util.Optional;

public interface HolidayService {
    List<Holiday> getAll(Optional<String> location, Optional<String> startDate, Optional<Integer> duration);

    Holiday getById(long id);

    void create(Holiday holiday);

    void update(Holiday holiday);

    void delete(int id);
}
