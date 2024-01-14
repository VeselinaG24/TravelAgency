package com.example.travelagencyproject.repositories.implementations;

import com.example.travelagencyproject.models.Holiday;
import com.example.travelagencyproject.repositories.interfaces.HolidayRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class HolidayRepositoryImpl implements HolidayRepository {
    private final SessionFactory sessionFactory;

    public HolidayRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Holiday> getAll(Optional<String> location, Optional<String> startDate, Optional<Integer> duration) {
        try (Session session = sessionFactory.openSession()) {
            String queryString = "from Holiday where 1=1";
            if (location.isPresent()) {
                queryString += " AND location=:location";
            }
            if (startDate.isPresent()) {
                queryString += " AND startDate=:startDate";
            }
            if (duration.isPresent()) {
                queryString += " AND duration=:duration";
            }

            Query<Holiday> query = session.createQuery(queryString, Holiday.class);

            if (location.isPresent()) {
                query.setParameter("location", location.orElse(" "));
            }
            if (startDate.isPresent()) {
                String date = startDate.get();
                Date newDate = java.sql.Date.valueOf(date);
                query.setParameter("startDate", newDate);
            }
            if (duration.isPresent()) {
                query.setParameter("duration", duration.orElse(0));
            }
            return query.list();
        }
    }

    @Override
    public Holiday getById(long id) {
        try (Session session = sessionFactory.openSession()) {
            Holiday holiday = session.get(Holiday.class, id);
            if (holiday == null) {
                throw new com.example.travelagencyproject.exceptions.EntityNotFoundException("Holiday", id);
            }
            return holiday;
        }
    }

    @Override
    public void create(Holiday holiday) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(holiday);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Holiday holiday) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(holiday);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(int id) {
        Holiday holidayToDelete = getById(id);
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(holidayToDelete);
            session.getTransaction().commit();
        }
    }
}
