package com.example.travelagencyproject.utils;

import com.example.travelagencyproject.models.Holiday;
import com.example.travelagencyproject.models.Reservation;
import com.example.travelagencyproject.models.dtos.CreateReservationDTO;
import com.example.travelagencyproject.models.dtos.UpdateReservationDTO;
import com.example.travelagencyproject.models.dtos.responses.ResponseReservationDTO;
import com.example.travelagencyproject.repositories.interfaces.HolidayRepository;
import com.example.travelagencyproject.repositories.interfaces.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class ReservationMapper {
    private final ReservationRepository reservationRepository;
    private final HolidayRepository holidayRepository;

    private final HolidayMapper holidayMapper;

    @Autowired
    public ReservationMapper(ReservationRepository reservationRepository, HolidayRepository holidayRepository, HolidayMapper holidayMapper) {
        this.reservationRepository = reservationRepository;
        this.holidayRepository = holidayRepository;
        this.holidayMapper = holidayMapper;
    }

    public Reservation fromDto(CreateReservationDTO reservationDTO) {
        Holiday holiday = holidayRepository.getById(reservationDTO.getHoliday());
        Reservation reservation = new Reservation();
        reservation.setContactName(reservationDTO.getContactName());
        reservation.setHoliday(holiday);
        reservation.setPhoneNumber(reservationDTO.getPhoneNumber());
        return reservation;
    }

    public Reservation fromDto(UpdateReservationDTO reservationDTO) {
        Holiday holiday = holidayRepository.getById(reservationDTO.getHoliday());
        Reservation reservation = reservationRepository.getById(reservationDTO.getId());
        reservation.setContactName(reservationDTO.getContactName());
        reservation.setHoliday(holiday);
        reservation.setPhoneNumber(reservationDTO.getPhoneNumber());
        return reservation;
    }
    public ResponseReservationDTO toDto(Reservation reservation){
        ResponseReservationDTO reservationDTO = new ResponseReservationDTO();
        reservationDTO.setId(reservation.getId());
        reservationDTO.setContactName(reservation.getContactName());
        reservationDTO.setHoliday(holidayMapper.toDto(reservation.getHoliday()));
        reservationDTO.setPhoneNumber(reservation.getPhoneNumber());
        return reservationDTO;
    }
}
