package com.hglam.controller;

import com.hglam.entity.Product;
import com.hglam.service.ProductQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductQueryController {
    @Autowired
    private ProductQueryService queryService;
    //defind an endpoint GET to fetch a list of all product
    @GetMapping
    public List<Product> fetchAllProducts(){
        return queryService.getProducts();
        //call method getProduct from service to get a list of product
    }
}
