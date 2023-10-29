package com.poc.webflux_api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;

import com.poc.webflux_api.Repositories.ProductRepository;
import com.poc.webflux_api.Utils.AppUtils;
import com.poc.webflux_api.dto.ProductDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public Flux<ProductDto> getAllProducts(){
        return productRepository.findAll().map(AppUtils::entityToDto);
    }


    //fetch single product item

    public Mono<ProductDto> getProductById(int id){
        return productRepository.findById(id).map(AppUtils::entityToDto);
    }


    //return producyt based on price range

    public Flux<ProductDto> getProductByPrice(double min, double max){
        return productRepository.findByPriceBetween(Range.closed(min, max));
    }
    


    //post api 
    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono){
        return productDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(productRepository::save)
                .map(AppUtils::entityToDto);
    }



    //update product
    public Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono, int id){
        return productRepository.findById(id)
                .flatMap(existingProduct -> productDtoMono.map(AppUtils::dtoToEntity)
                        .doOnNext(e -> e.setId(id)))
                .flatMap(productRepository::save)
                .map(AppUtils::entityToDto);
    }



    //delete product

    public Mono<Void> deleteProduct(int id){
        return productRepository.deleteById(id);
    }
}
