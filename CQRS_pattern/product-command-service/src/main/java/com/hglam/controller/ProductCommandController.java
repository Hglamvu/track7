package com.hglam.controller;

import com.hglam.dto.ProductEvent;
import com.hglam.entity.Product;
import com.hglam.repository.ProductRepository;
import com.hglam.service.ProductCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductCommandController {

    @Autowired
    private ProductCommandService commandService;
    
    //defind 1 endpoint POST api tạo product
    @PostMapping
    public Product createProduct(@RequestBody ProductEvent productEvent) {
        return commandService.createProduct(productEvent);
    }
    // defind endpoint PUT update product theo id
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody ProductEvent productEvent) {
        return commandService.updateProduct(id, productEvent);
    }
}
