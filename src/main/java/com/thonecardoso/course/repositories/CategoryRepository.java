package com.thonecardoso.course.repositories;

import com.thonecardoso.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
