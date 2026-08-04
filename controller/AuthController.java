package com.ems.controller;


import com.ems.dto.LoginRequest;

import com.ems.service.AuthService;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



@RestController

@RequestMapping("/api/auth")

@RequiredArgsConstructor

@CrossOrigin(
        origins = "http://localhost:5173"
)

public class AuthController {



    private final AuthService authService;




    @PostMapping("/login")

    public ResponseEntity<String> login(

            @RequestBody LoginRequest request

    ){


        return ResponseEntity.ok(

                authService.login(request)

        );

    }


}
