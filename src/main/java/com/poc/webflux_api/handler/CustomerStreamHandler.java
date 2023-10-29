package com.poc.webflux_api.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;

import org.springframework.web.reactive.function.server.ServerResponse;

import com.poc.webflux_api.dao.CustomerDao;
import com.poc.webflux_api.dto.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {
    


    @Autowired
    private CustomerDao dao;


    public Mono<ServerResponse> loadCustomersStream(ServerRequest request){
        Flux<Customer> customerList= dao.getCustomerList();
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
        .body(customerList,Customer.class);        
    }


     



}
