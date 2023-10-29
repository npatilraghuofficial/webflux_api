package com.poc.webflux_api.Repositories;

import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.poc.webflux_api.Entity.ProductEntity;
import com.poc.webflux_api.dto.ProductDto;

import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<ProductEntity, Integer> {


    Flux<ProductDto> findByPriceBetween(Range<Double> priceRange);
    
}
