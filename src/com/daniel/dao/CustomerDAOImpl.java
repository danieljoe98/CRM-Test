package com.daniel.dao;

import com.daniel.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    //need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //create query
        Query<Customer> query =
                currentSession.createQuery("FROM Customer ORDER BY lastName", Customer.class);

        //execute query and get result list
        List<Customer> customers = query.getResultList();

        //return list of customer
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        //get current hibernate session
        Session session = sessionFactory.getCurrentSession();

        //saveOrUpdate the customer.. IF PRIMARY KEY IS EMPTY THEN INSERT NEW CUSTOMER ELSE UPDATE EXISTING CUSTOMER
        session.saveOrUpdate(customer);

    }

    @Override
    public Customer getCustomer(int theId) {
        //get current hibernate session
        Session session = sessionFactory.getCurrentSession();

        //now retrieve from db using the primary key
        Customer customer = session.get(Customer.class, theId);

        return customer;
    }

    @Override
    public void deleteCustomer(int theId) {
        //get the current session
        Session currentSession = sessionFactory.getCurrentSession();

        //delete object with primary key
        Query query = currentSession.createQuery("DELETE FROM Customer where id=:customerId");
        query.setParameter("customerId",theId);

        //execute :: using executeUpdate can perform both update and delete
        query.executeUpdate();

    }
}
