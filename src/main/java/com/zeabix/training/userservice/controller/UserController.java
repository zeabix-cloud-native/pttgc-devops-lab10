package com.zeabix.training.userservice.controller;

import com.zeabix.training.userservice.dto.UserProfileRequest;
import com.zeabix.training.userservice.dto.UserProfileResponse;
import com.zeabix.training.userservice.entity.UserProfile;
import com.zeabix.training.userservice.exception.UserNotFoundException;
import com.zeabix.training.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/profiles")
    @ResponseStatus(HttpStatus.CREATED)
    public UserProfileResponse createUserProfile(@RequestBody UserProfileRequest req){
        UserProfile entity = dtoToEntity.apply(req);

        UserProfile saved = userService.addUserProfile(entity);

        UserProfileResponse response = new UserProfileResponse();
        response.setId(saved.getId());
        response.setFirstName(saved.getFirstName());
        response.setLastName(saved.getLastName());
        response.setUsername(saved.getUsername());
        return response;
    }

    @GetMapping("/profiles/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserProfileResponse getUserProfile(@PathVariable Long id) throws UserNotFoundException {
        UserProfile p = userService.getUserDetail(id);
        UserProfileResponse response = new UserProfileResponse();
        response.setId(p.getId());
        response.setUsername(p.getUsername());
        response.setFirstName(p.getFirstName());
        response.setLastName(p.getLastName());
        return  response;
    }

    @GetMapping("/profiles")
    @ResponseStatus(HttpStatus.OK)
    public List<UserProfileResponse> getAllUserProfiles(){
        return userService.getAllUsers().stream()
                .map(entityToDTO)
                .collect(Collectors.toList());
    }

    private final Function<UserProfile, UserProfileResponse> entityToDTO = (entity) -> {
        UserProfileResponse response = new UserProfileResponse();
        response.setId(entity.getId());
        response.setUsername(entity.getUsername());
        response.setFirstName(entity.getFirstName());
        response.setLastName(entity.getLastName());
        return  response;
    };

    private final Function<UserProfileRequest, UserProfile> dtoToEntity = (dto) -> {
        UserProfile entity = new UserProfile();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setUsername(dto.getUsername());
        return entity;
    };


}
