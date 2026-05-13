package com.pankaj.ecommerce.product_service.repository;

import com.pankaj.ecommerce.product_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
