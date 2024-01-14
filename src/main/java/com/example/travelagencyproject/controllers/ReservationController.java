package com.example.travelagencyproject.controllers;

import java.util.List;

import com.example.travelagencyproject.models.Holiday;
import com.example.travelagencyproject.models.Reservation;
import com.example.travelagencyproject.models.dtos.CreateReservationDTO;
import com.example.travelagencyproject.models.dtos.UpdateReservationDTO;
import com.example.travelagencyproject.models.dtos.responses.ResponseReservationDTO;
import com.example.travelagencyproject.services.interfaces.HolidayService;
import com.example.travelagencyproject.services.interfaces.ReservationService;
import com.example.travelagencyproject.utils.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService service;
    private final ReservationMapper reservationMapper;
    private final HolidayService holidayService;

    @Autowired
    public ReservationController(ReservationService service, ReservationMapper reservationMapper, HolidayService holidayService) {
        this.service = service;
        this.reservationMapper=reservationMapper;
        this.holidayService = holidayService;
    }
    @GetMapping("/{reservationId}")
    public ResponseEntity<ResponseReservationDTO> getReservationById(@PathVariable int reservationId) {
        try {
            Reservation reservation = service.getById(reservationId);
            return new ResponseEntity<>(reservationMapper.toDto(reservation), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<ResponseReservationDTO> update(@RequestBody UpdateReservationDTO reservationDTO) {
        try {
            Reservation reservation = reservationMapper.fromDto(reservationDTO);
            service.update(reservation);
            return new ResponseEntity<>(reservationMapper.toDto(reservation), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping()
    public ResponseEntity<ResponseReservationDTO> create(@RequestBody CreateReservationDTO reservationDTO){
        try {
            Reservation reservation = reservationMapper.fromDto(reservationDTO);
            service.create(reservation);
            Holiday holiday = reservation.getHoliday();
            holiday.setFreeSlots(holiday.getFreeSlots()-1);
            holidayService.update(holiday);
            return new ResponseEntity<>(reservationMapper.toDto(reservation), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Boolean> delete(@PathVariable int reservationId) {
        try {
            Reservation reservation = service.getById(reservationId);
            Holiday holiday = reservation.getHoliday();
            holiday.setFreeSlots(holiday.getFreeSlots()+1);
            service.delete(reservationId);
            holidayService.update(holiday);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
