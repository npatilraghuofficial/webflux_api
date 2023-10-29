package com.poc.webflux_api.Utils;

import org.springframework.beans.BeanUtils;

import com.poc.webflux_api.Entity.ProductEntity;
import com.poc.webflux_api.dto.ProductDto;

public class AppUtils {
    
    public static  ProductDto  entityToDto(ProductEntity product){

        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }


    public static  ProductEntity dtoToEntity(ProductDto productDto){

        ProductEntity product = new ProductEntity();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }
    
}
