package com.example.travelagencyproject.repositories.implementations;

import com.example.travelagencyproject.exceptions.EntityNotFoundException;
import com.example.travelagencyproject.models.Location;
import com.example.travelagencyproject.repositories.interfaces.LocationRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class LocationRepositoryImpl implements LocationRepository {
    private final SessionFactory sessionFactory;

    public LocationRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Location> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Location> query = session.createQuery("from Location ", Location.class);
            return query.list();
        }
    }

    @Override
    public Location getById(long id) {
        try (Session session = sessionFactory.openSession()) {
            Location location = session.get(Location.class, id);
            if (location == null) {
                throw new EntityNotFoundException("Location", id);
            }
            return location;
        }
    }

    @Override
    public Location getByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Query<Location> query = session.createQuery("from Location where city = :name OR country = :name", Location.class);
            query.setParameter("name", name);
            List<Location> locations = query.list();
            if (locations.size() == 0) {
                throw new EntityNotFoundException("Name", "name", name);
            }

            return locations.get(0);
        }
    }

    @Override
    public void create(Location location) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(location);
            session.getTransaction().commit();        }
    }

    @Override
    public void update(Location location) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(location);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(int id) {
        Location locationToDelete = getById(id);
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(locationToDelete);
            session.getTransaction().commit();
        }
    }
}
