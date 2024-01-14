package com.example.travelagencyproject.repositories.implementations;


import com.example.travelagencyproject.models.Reservation;
import com.example.travelagencyproject.repositories.interfaces.ReservationRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {
    private final SessionFactory sessionFactory;

    public ReservationRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Reservation> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Reservation> query = session.createQuery("from Reservation ", Reservation.class);
            return query.list();
        }
    }

    @Override
    public Reservation getById(long id) {
        try (Session session = sessionFactory.openSession()) {
            Reservation reservation = session.get(Reservation.class, id);
            if (reservation == null) {
                throw new com.example.travelagencyproject.exceptions.EntityNotFoundException("Reservation", id);
            }
            return reservation;
        }
    }

    @Override
    public void create(Reservation reservation) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(reservation);
            session.getTransaction().commit();        }
    }

    @Override
    public void update(Reservation reservation) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(reservation);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(int id) {
        Reservation reservationToDelete = getById(id);
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(reservationToDelete);
            session.getTransaction().commit();
        }
    }
}
