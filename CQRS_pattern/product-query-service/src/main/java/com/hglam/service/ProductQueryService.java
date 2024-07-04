package com.hglam.service;

import com.hglam.dto.ProductEvent;
import com.hglam.entity.Product;
import com.hglam.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductQueryService {

    @Autowired
    private ProductRepository repository;
    //call the list of product from the repo
    public List<Product> getProducts() {
        return repository.findAll();
    }

    //this method proceed events from kafka topics: "product-event-topic"
    @KafkaListener(topics = "product-event-topic",groupId = "product-event-group")
    public void processProductEvents(ProductEvent productEvent) {
        //get the product from product Event
        Product product = productEvent.getProduct();
        //deal with the event "Create Product"
        if (productEvent.getEventType().equals("CreateProduct")) {
            repository.save(product);
        }
        //deal with the event "Update Product"
        if (productEvent.getEventType().equals("UpdateProduct")) {
            //get the Product from the repository based on their id
            Product existingProduct = repository.findById(product.getId()).get();
            //update the info of the current Product with the info of the new ones
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setDescription(product.getDescription());
            //save the info of the product into the repository
            repository.save(existingProduct);
        }
    }
}
