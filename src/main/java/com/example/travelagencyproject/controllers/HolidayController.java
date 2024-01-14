package com.example.travelagencyproject.controllers;

import java.util.List;
import java.util.Optional;

import com.example.travelagencyproject.models.Holiday;
import com.example.travelagencyproject.models.dtos.CreateHolidayDTO;
import com.example.travelagencyproject.models.dtos.UpdateHolidayDTO;
import com.example.travelagencyproject.models.dtos.responses.ResponseHolidayDTO;
import com.example.travelagencyproject.services.interfaces.HolidayService;
import com.example.travelagencyproject.utils.HolidayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/holidays")
public class HolidayController {


    private final HolidayService service;
    private final HolidayMapper holidayMapper;
    @Autowired
    public HolidayController(HolidayService service, HolidayMapper holidayMapper) {
        this.service = service;
        this.holidayMapper=holidayMapper;
    }
    @GetMapping("/{holidayId}")
    public ResponseEntity<ResponseHolidayDTO> getHolidayById(@PathVariable int holidayId) {
        try {
            Holiday holiday = service.getById(holidayId);
            return new ResponseEntity<>(holidayMapper.toDto(holiday), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Holiday>> getAllHolidays(
            @RequestParam(name = "location", required = false) Optional<String> location,
            @RequestParam(name = "startDate", required = false) Optional<String> startDate,
            @RequestParam(name = "duration", required = false) Optional<Integer> duration){
        return new ResponseEntity<>(service.getAll(location, startDate, duration), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<ResponseHolidayDTO> update(@RequestBody UpdateHolidayDTO holidayDTO) {
        try {
            Holiday holiday = holidayMapper.fromDto(holidayDTO);
            service.update(holiday);
            return new ResponseEntity<>(holidayMapper.toDto(holiday), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping()
    public ResponseEntity <ResponseHolidayDTO> create(@RequestBody CreateHolidayDTO holidayDTO){
        try {
            Holiday holiday = holidayMapper.fromDto(holidayDTO);
            service.create(holiday);
            return new ResponseEntity<>(holidayMapper.toDto(holiday), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{holidayId}")
    public ResponseEntity<Boolean> delete(@PathVariable int holidayId) {
        try {
            service.delete(holidayId);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
