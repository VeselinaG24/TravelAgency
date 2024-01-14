package com.example.travelagencyproject.utils;

import com.example.travelagencyproject.models.Holiday;
import com.example.travelagencyproject.models.Location;
import com.example.travelagencyproject.models.dtos.CreateHolidayDTO;
import com.example.travelagencyproject.models.dtos.UpdateHolidayDTO;
import com.example.travelagencyproject.models.dtos.responses.ResponseHolidayDTO;
import com.example.travelagencyproject.repositories.interfaces.HolidayRepository;
import com.example.travelagencyproject.repositories.interfaces.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class HolidayMapper {
    private final HolidayRepository holidayRepository;
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;
    @Autowired
    public HolidayMapper(HolidayRepository holidayRepository, LocationRepository locationRepository, LocationMapper locationMapper) {
        this.holidayRepository = holidayRepository;
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    public Holiday fromDto(UpdateHolidayDTO holidayDTO) {
        Location location = locationRepository.getById(holidayDTO.getLocation());

        Holiday holiday = holidayRepository.getById(holidayDTO.getId());
        holiday.setDuration(holidayDTO.getDuration());
        holiday.setLocation(location);
        holiday.setPrice(holidayDTO.getPrice());
        holiday.setTitle(holidayDTO.getTitle());
        holiday.setStartDate(holidayDTO.getStartDate());
        holiday.setFreeSlots(holidayDTO.getFreeSlots());

        return holiday;
    }

    public Holiday fromDto(CreateHolidayDTO holidayDTO) {
        Location location = locationRepository.getById(holidayDTO.getLocation());

        Holiday holiday = new Holiday();
        holiday.setDuration(holidayDTO.getDuration());
        holiday.setLocation(location);
        holiday.setPrice(holidayDTO.getPrice());
        holiday.setTitle(holidayDTO.getTitle());
        holiday.setStartDate(holidayDTO.getStartDate());
        holiday.setFreeSlots(holidayDTO.getFreeSlots());

        return holiday;
    }
    public ResponseHolidayDTO toDto(Holiday holiday){

        ResponseHolidayDTO holidayDTO = new ResponseHolidayDTO();
        holidayDTO.setDuration(holiday.getDuration());
        holidayDTO.setLocation(locationMapper.toDto(holiday.getLocation()));
        holidayDTO.setPrice(Double.parseDouble(holiday.getPrice()));
        holidayDTO.setTitle(holiday.getTitle());
        holidayDTO.setStartDate(holiday.getStartDate());
        holidayDTO.setFreeSlots(holiday.getFreeSlots());
        return holidayDTO;
    }

}
