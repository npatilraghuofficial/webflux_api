package com.poc.webflux_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    
   
    private int id;
    private String name;
    private String description;
    private double price;
    private int qty;




}
