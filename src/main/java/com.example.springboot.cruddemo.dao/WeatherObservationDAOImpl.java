package com.example.springboot.cruddemo.dao;

import model.WeatherObservation;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import repo.WeatherObservationRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class WeatherObservationDAOImpl implements WeatherObservationRepository {

    private final EntityManager em;

    public WeatherObservationDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<WeatherObservation> findAll() {
        //get the current hibernate session
        Session session = em.unwrap(Session.class);
        //create a query
        String sql = "Select e from WeatherObservation e";
        Query<WeatherObservation> query = session.createQuery(sql, WeatherObservation.class);
        //execute query and return result list
        return query.getResultList();
    }

    @Override
    public WeatherObservation findById(int id) {
        //get the current hibernate session
        Session session = em.unwrap(Session.class);
        //get Employee
        return session.get(WeatherObservation.class, id);
    }

    @Override
    public void save(WeatherObservation e) {
        //get the current hibernate session
        Session session = em.unwrap(Session.class);

        //save object
        session.saveOrUpdate(e);
    }

    @Override
    public void deleteById(int id) {
        //get the current hibernate session
        Session session = em.unwrap(Session.class);

        //delete object with primary key
        Query<WeatherObservation> query = session.createQuery("delete from WeatherObservation e where e.id = :weatherObservationId");
        query.setParameter("weatherObservationId", id);
        query.executeUpdate();
    }
}
