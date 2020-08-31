package com.example.springboot.cruddemo.dao;

import com.example.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager em;

    public EmployeeDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> findAll() {
        //get the current hibernate session
        Session session = em.unwrap(Session.class);
        //create a query
        String sql = "Select e from Employee e";
        Query<Employee> query = session.createQuery(sql, Employee.class);
        //execute query and return result list
        List<Employee> result = query.getResultList();
        return result;
    }

    @Override
    public Employee findById(int id) {
        //get the current hibernate session
        Session session = em.unwrap(Session.class);
        //get Employee
        Employee e = session.get(Employee.class, id);
        return e;
    }

    @Override
    public void save(Employee e) {
        //get the current hibernate session
        Session session = em.unwrap(Session.class);

        //save Employee
        session.saveOrUpdate(e);
    }

    @Override
    public void deleteById(int id) {
        //get the current hibernate session
        Session session = em.unwrap(Session.class);

        //delete Employee with primary key
        Query query = session.createQuery("delete from Employee e where e.id = :employeeId");
        query.setParameter("employeeId",id);

        query.executeUpdate();
    }
}
