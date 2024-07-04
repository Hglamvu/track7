package com.hglam.hexagonal.application;

import com.hglam.hexagonal.domain.Product;
import com.hglam.hexagonal.port.out.ProductRepository;

import java.util.Optional;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    //the method of adding Product
    public void addProduct(Product product){
        productRepository.save(product);
    }
    //the method of fetching product based on its id
    public Optional<Product> getProduct(Long id ){
        return productRepository.findById(id);
    }
}
