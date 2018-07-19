package com.daniel.controller;

import com.daniel.entity.Customer;
import com.daniel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //need to inject the DAO into this controller
    //need to inject the customer DAO
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model){
        //get the customers from the DAO
        List<Customer> theCustomers = customerService.getCustomers();

        //add the customers to the model
        model.addAttribute("customers", theCustomers); // left is the name while on the right hand side is value

        return "list-customer";
    }

    @GetMapping("/addForm")
    public String showAddForm(Model theModel){

        //create model attribute to bind form data
        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer); // left is reference for the JSP while right-hand side is the actual value

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){

        //save the customer using our service
        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/updateForm")
    public String showUpdateForm(@RequestParam("customerId") int theId, Model theModel){
        //get the customer from the service
        Customer theCustomer = customerService.getCustomer(theId);

        //set customer as model attribute to pre-populate the form
        theModel.addAttribute("customer", theCustomer);

        //send over to our form
        return "customer-form";
    }

    @GetMapping("delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){
        //delete the customer
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

}
