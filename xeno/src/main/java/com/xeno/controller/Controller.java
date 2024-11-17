package com.xeno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.xeno.config.CustomerOrderService;
import com.xeno.entity.Corder;
import com.xeno.entity.Customer;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private CustomerOrderService customerOrderService;

    // Create Customer
    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        System.out.println("Received Customer: " + customer); // Debug log
        Customer savedCustomer = customerOrderService.saveCustomer(customer);
        if (savedCustomer != null) {
            System.out.println("Saved Customer: " + savedCustomer); // Debug log
            return ResponseEntity.ok(savedCustomer);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Create Order
    @PostMapping("/orders")
    public ResponseEntity<Corder> createOrder(@RequestBody Corder order) {
        Corder createdOrder = customerOrderService.saveOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    // Get All Customers
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerOrderService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    // Get All Orders
    @GetMapping("/orders")
    public ResponseEntity<List<Corder>> getAllOrders() {
        List<Corder> orders = customerOrderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
}
