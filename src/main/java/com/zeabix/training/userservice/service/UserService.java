package com.zeabix.training.userservice.service;

import com.zeabix.training.userservice.entity.UserProfile;
import com.zeabix.training.userservice.exception.UserNotFoundException;
import com.zeabix.training.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public UserProfile addUserProfile(UserProfile profile){
        return repository.save(profile);
    }

    public UserProfile getUserDetail(Long id) throws UserNotFoundException {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public List<UserProfile> getAllUsers(){
        return repository.findAll();
    }
}
