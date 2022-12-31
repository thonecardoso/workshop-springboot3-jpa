package com.thonecardoso.course.repositories;

import com.thonecardoso.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
