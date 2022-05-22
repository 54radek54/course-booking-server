package com.example.coursebookingserver.controllers;

import com.example.coursebookingserver.model.AppUser;
import com.example.coursebookingserver.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class AppUserController {

    private final AppUserService appUserService;


    @PostMapping("/user")
    public ResponseEntity addUser(@RequestBody AppUser appUser) {
        try {
            appUserService.addUser(appUser);
            return ResponseEntity.ok().body(appUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
