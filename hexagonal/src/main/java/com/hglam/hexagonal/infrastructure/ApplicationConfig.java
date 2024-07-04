package com.hglam.hexagonal.infrastructure;

import com.hglam.hexagonal.application.ProductService;
import com.hglam.hexagonal.port.out.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//denote as a configuration in spring
public class ApplicationConfig {
    @Bean
    //defind a bean productService
    public ProductService productService(ProductRepository productRepository){
        return new ProductService(productRepository);
    }

}
