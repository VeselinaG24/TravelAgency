package com.example.travelagencyproject.services.interfaces;

import com.example.travelagencyproject.models.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAll();

    Reservation getById(long id);

    void create(Reservation reservation);

    void update(Reservation reservation);

    void delete(int id);
}
