package com.hglam.hexagonal.adapter.in;

import com.hglam.hexagonal.application.ProductService;
import com.hglam.hexagonal.domain.Product;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    //constructor of a productService
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    //defind an endpoint POST to adding new Product
    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
    //defind an endpoint Get to fetching Product based on its id
    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }
}
