package com.example.travelagencyproject.repositories.interfaces;


import com.example.travelagencyproject.models.Reservation;

import java.util.List;

public interface ReservationRepository {
    List<Reservation> getAll();

    Reservation getById(long id);

    void create(Reservation reservation);

    void update(Reservation reservation);

    void delete(int id);
}
