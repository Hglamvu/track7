package com.hglam.dto;

import com.hglam.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEvent {
    //type of event (create, read, update, delete)
    private String eventType;
    private Product product;
}
