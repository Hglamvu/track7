package com.hglam.hexagonal.port.out;

import com.hglam.hexagonal.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
