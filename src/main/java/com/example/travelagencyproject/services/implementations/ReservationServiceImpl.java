package com.example.travelagencyproject.services.implementations;

import com.example.travelagencyproject.models.Reservation;
import com.example.travelagencyproject.repositories.interfaces.ReservationRepository;
import com.example.travelagencyproject.services.interfaces.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository repository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Reservation> getAll() {
        return repository.getAll();
    }

    @Override
    public Reservation getById(long id) {
        return repository.getById(id);
    }

    @Override
    public void create(Reservation reservation) {
        repository.create(reservation);
    }

    @Override
    public void update(Reservation reservation) {
        repository.update(reservation);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
