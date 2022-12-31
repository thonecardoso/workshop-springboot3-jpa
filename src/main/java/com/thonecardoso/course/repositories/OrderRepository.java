package com.thonecardoso.course.repositories;

import com.thonecardoso.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
