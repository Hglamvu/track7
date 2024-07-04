package com.hglam.hexagonal.adapter.out;

import com.hglam.hexagonal.domain.Product;
import com.hglam.hexagonal.port.out.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbProductRepository extends ProductRepository {
}
