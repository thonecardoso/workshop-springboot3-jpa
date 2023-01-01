package com.thonecardoso.course.services;

import com.thonecardoso.course.entities.User;
import com.thonecardoso.course.repositories.UserRepository;
import com.thonecardoso.course.services.exceptions.DatabaseException;
import com.thonecardoso.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return repository.save(user);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public void update(Long id, User userToUpdate) {
        var user = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
        updateData(userToUpdate, user);
        repository.save(user);
    }

    private void updateData(User userToUpdate, User user) {
        user.setEmail(userToUpdate.getEmail());
        user.setName(userToUpdate.getName());
        user.setPhone(userToUpdate.getPhone());
    }
}
