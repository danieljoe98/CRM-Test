package com.daniel.service;

import com.daniel.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
