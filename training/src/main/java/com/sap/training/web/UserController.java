package com.sap.training.web;

import com.sap.training.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public List<User> getUser() {
        List<User> lt = new ArrayList<>();
        User user = new User(1, "Kaushiki", "Scholar-2YB");
        lt.add(user);
        return lt;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        logger.info("Entering createUser() method. ");
        logger.info(user.toString());
        logger.info("Some more loggers...");
        return user;
    }
}
