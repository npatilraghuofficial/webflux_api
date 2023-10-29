package com.poc.webflux_api.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.poc.webflux_api.handler.CustomerHandler;
import com.poc.webflux_api.handler.CustomerStreamHandler;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class RouterConfig {
    
    @Autowired
    public CustomerHandler customerHandler;

    @Autowired
    public CustomerStreamHandler customerStreamHandler;
    
    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return route()
        .GET("/router/customers", customerHandler::loadCustomers)
        .GET("/router/customers/stream" ,customerStreamHandler::loadCustomersStream)
        .GET("/router/customer/{input}",customerHandler::findCustomer)
        .POST("/router/customer/save",customerHandler::saveCustomer)
        
        .build();

    }   
}
