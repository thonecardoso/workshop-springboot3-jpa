package com.thonecardoso.course.services;

import com.thonecardoso.course.entities.User;
import com.thonecardoso.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        return repository.findById(id).orElseThrow();
    }

    public User insert(User user){
        return repository.save(user);
    }

    public void delete(Long id){
        var user = repository.findById(id).orElseThrow();
        repository.delete(user);
    }

    public void update(Long id, User userToUpdate) {
        var user = repository.getReferenceById(id);
        user.setEmail(userToUpdate.getEmail());
        user.setName(userToUpdate.getName());
        user.setPhone(userToUpdate.getPhone());

        repository.save(user);
    }
}
