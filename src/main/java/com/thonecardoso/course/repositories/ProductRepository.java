package com.thonecardoso.course.repositories;

import com.thonecardoso.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
