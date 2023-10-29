package com.poc.webflux_api;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.poc.webflux_api.Controllers.ProductController;
import com.poc.webflux_api.Service.ProductService;
import com.poc.webflux_api.dto.ProductDto;

import reactor.core.publisher.Mono;

//integration test
@RunWith(SpringRunner.class)
@WebFluxTest(ProductController.class)
class WebfluxApiApplicationTests {

	
	@Autowired
	private WebTestClient webTestClient;

	@Autowired
	private ProductService service;

	@Test
	public void saveProductTest(){
		Mono <ProductDto> productDtoMono = Mono.just(new ProductDto(1, "TV", null, 1000.00, 0));
		when(service.saveProduct(productDtoMono)).thenReturn(productDtoMono);

		webTestClient.post().uri("/products")
				.body(Mono.just(productDtoMono), ProductDto.class)
				.exchange()
				.expectStatus().isOk();
	}

}




