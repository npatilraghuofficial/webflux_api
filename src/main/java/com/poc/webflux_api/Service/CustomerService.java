package com.poc.webflux_api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.webflux_api.dao.CustomerDao;
import com.poc.webflux_api.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public List<Customer>loadAllCustomers(){
        long start= System.currentTimeMillis();
        List<Customer> customers =customerDao.getCustomers();
        long end= System.currentTimeMillis();
        System.out.println("Total time taken ="+(end-start));
        
        return customers;
    }
    


     public Flux<Customer>loadAllCustomersStream(){
        long start= System.currentTimeMillis();
        Flux<Customer> customers =customerDao.getCustomersStream();
        long end= System.currentTimeMillis();
        System.out.println("Total time taken ="+(end-start));
        
        return customers;
    }
}
