package com.zeabix.training.userservice.repository;

import com.zeabix.training.userservice.entity.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserProfile, Long> {
    List<UserProfile> findAll();
}
