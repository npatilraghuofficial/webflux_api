package com.poc.webflux_api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.webflux_api.Service.CustomerService;
import com.poc.webflux_api.dto.Customer;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public List<Customer> getAllCustomers(){
        return customerService.loadAllCustomers();

    }

    @GetMapping("/stream")
    public Flux<Customer> getAllCustomersStream(){
        return customerService.loadAllCustomersStream();

    }
    
}
