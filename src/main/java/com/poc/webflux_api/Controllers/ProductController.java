package com.poc.webflux_api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.webflux_api.Service.ProductService;
import com.poc.webflux_api.dto.ProductDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {
    

    @Autowired
    private ProductService productService;


    @GetMapping("/")
    public Flux<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    //using id USING PATh variable
   @GetMapping("/{id}")
    public Mono<ProductDto> getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    //using price range
    @GetMapping("/product-range")
    public Flux<ProductDto> getProductByPrice(@RequestParam("min") double min,@RequestParam("max") double max){
        return productService.getProductByPrice(min, max);
    }

    //save
    
    @PostMapping
    public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto> productDtoMono){
        return productService.saveProduct(productDtoMono);
    }

    //PUT
    @PutMapping("/update/{id}")
    public Mono<ProductDto> updateProduct(@RequestBody Mono<ProductDto> productDtoMono, @PathVariable int id){
        return productService.updateProduct(productDtoMono, id);
    }


    //delete product

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }


}
