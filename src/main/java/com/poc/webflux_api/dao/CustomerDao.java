package com.poc.webflux_api.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.poc.webflux_api.dto.Customer;

import reactor.core.publisher.Flux;

@Component
public class CustomerDao {
    private static void sleepExecution(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Customer>getCustomers(){
        return IntStream.rangeClosed(1,10)
        .peek(CustomerDao::sleepExecution)
        .peek(i->System.out.println("processing count   ="+i))
        .mapToObj(i->new Customer(i,"customer"+i,"customer"+i+"@gmail.com"))
        .collect(Collectors.toList());
    }



      public Flux<Customer>getCustomersStream(){
        return Flux.range(1,10)
        .delayElements(Duration.ofSeconds(1))
        .doOnNext(i->System.out.println("processing count   ="+i))
        .map(i->new Customer(i,"customer"+i,"customer   "+i+"@gmail.com"))
        .log();

    }
    

       public Flux<Customer>getCustomerList(){
        return Flux.range(1,10)
        .delayElements(Duration.ofSeconds(1))
        .doOnNext(i->System.out.println("processing count   ="+i))
        .map(i->new Customer(i,"customer"+i,"customer   "+i+"@gmail.com"));
        

    }


    
    
}
