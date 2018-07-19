package com.daniel.dao;

import com.daniel.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);


    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
