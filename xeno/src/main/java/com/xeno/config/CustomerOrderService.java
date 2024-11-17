package com.xeno.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xeno.entity.Corder;
import com.xeno.entity.Customer;
import com.xeno.repo.CRepository;
import com.xeno.repo.ORepo;

@Service
public class CustomerOrderService {

    @Autowired
    private CRepository customerRepository;

    @Autowired
    private ORepo orderRepository;

    // Save Customer
    public Customer saveCustomer(Customer customer) {
        System.out.println("Saving customer: " + customer); // Debug log
        return customerRepository.save(customer); // Ensure save() is called properly
    }

    // Save Order
    public Corder saveOrder(Corder order) {
        return orderRepository.save(order);
    }

    // Get All Customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get All Orders
    public List<Corder> getAllOrders() {
        return orderRepository.findAll();
    }
   
}
