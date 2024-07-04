package com.hglam.service;

import com.hglam.dto.ProductEvent;
import com.hglam.entity.Product;
import com.hglam.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    
    public Product createProduct(ProductEvent productEvent){
        Product productDO = repository.save(productEvent.getProduct());
        //create an event with the type of CreateProduct 
        ProductEvent event=new ProductEvent("CreateProduct", productDO);
        kafkaTemplate.send("product-event-topic", event);
        //send event to kafka topic: product-event-topic
        return productDO;
    }
        //method update product through id 
    public Product updateProduct(long id,ProductEvent productEvent){
        //get the product from repository through id
        Product existingProduct = repository.findById(id).get();
        Product newProduct=productEvent.getProduct();
        existingProduct.setName(newProduct.getName());
        existingProduct.setPrice(newProduct.getPrice());
        existingProduct.setDescription(newProduct.getDescription());
        //save the info of product into repository
        Product productDO = repository.save(existingProduct);
        //create an event with the eventType of UpdateProduct
        ProductEvent event=new ProductEvent("UpdateProduct", productDO);
        kafkaTemplate.send("product-event-topic", event);
        //send the event to Kafka topic: product-event-topic with the eventType of Update
        return productDO;
    }

}

