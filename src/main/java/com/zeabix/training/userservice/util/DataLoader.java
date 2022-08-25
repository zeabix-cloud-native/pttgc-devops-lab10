package com.zeabix.training.userservice.util;

import com.zeabix.training.userservice.entity.UserProfile;
import com.zeabix.training.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository repository;

    @Autowired
    public DataLoader(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (repository.findAll().size() < 10){
            UserProfile p = new UserProfile();
            p.setUsername("abc");
            p.setFirstName("Apilat");
            p.setLastName("Jonhson");

            UserProfile q = new UserProfile();
            q.setUsername("beebeeja");
            q.setFirstName("Warunee");
            q.setLastName("Jonhson");

            repository.save(p);
            repository.save(q);


        }
    }
}
