package com.example.crudproject.controller;

import com.example.crudproject.model.Login;
import com.example.crudproject.model.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {

        if ("usuario@esoft.com".equals(login.getEmail()) &&
                "Abc123".equals(login.getPassword())) {

            return ResponseEntity.ok(
                    new Token(UUID.randomUUID().toString())
            );
        }

        return ResponseEntity.status(401).build();
    }
}