package com.luv2code.springdemo.rest;


import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> listCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer customer=customerService.getCustomer(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        }
        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer) {

        // also just in case the pass an id in JSON ... set id to 0
        // this is force a save of new item ... instead of update

        theCustomer.setId(0);

        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }

    @PutMapping("/customers")
    public Customer UpdateCustomer(@RequestBody Customer theCustomer) {

        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }
    @DeleteMapping("/customers/{customerId")
    public String deleteCustomer(@PathVariable int customerId) {

        Customer tempCustomer = customerService.getCustomer(customerId);
        if (tempCustomer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        }

        customerService.deleteCustomer(customerId);

        return "Deleted customer id - " + customerId;
    }


}
