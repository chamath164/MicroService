package com.sliit.mtit.microservice.accountservice.controller;

import com.sliit.mtit.microservice.accountservice.dto.UserRequest;
import com.sliit.mtit.microservice.accountservice.dto.UserResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class AccountController {

    @RequestMapping(consumes = "application/json", produces = "application/json")
    public @ResponseBody UserResponse createUser(@RequestBody UserRequest userRequest){
        System.out.println(" UserDetails : " + userRequest);

        var UserResponse = new UserResponse();
        UserResponse.setUserId(UUID.randomUUID().toString());
        UserResponse.setMessage("Successfully created the user");

        return UserResponse;
    }
}
