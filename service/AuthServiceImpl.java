package com.ems.service;


import com.ems.dto.LoginRequest;

import com.ems.entity.User;

import com.ems.repository.UserRepository;


import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;



@Service

@RequiredArgsConstructor

public class AuthServiceImpl 
        implements AuthService {



    private final UserRepository userRepository;



    @Override
    public String login(
            LoginRequest request){



        User user =
                userRepository
                .findByUsername(
                    request.getUsername()
                )
                .orElseThrow(
                    () ->
                    new RuntimeException(
                    "User not found"
                    )
                );



        if(!user.getPassword()
                .equals(request.getPassword())){


            throw new RuntimeException(
                    "Invalid password"
            );

        }



        return "Login successful";

    }

}
