package com.thonecardoso.course.resources;

import com.thonecardoso.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        var u = new User(1L,"Maria", "Maria@gmail.com", "99999999", "1234");
        return ResponseEntity.ok().body(u);
    }
}
