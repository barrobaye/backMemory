package org.example.myusers.controller;

import lombok.RequiredArgsConstructor;
import org.example.baseservice.dto.UserDto;
import org.example.myusers.service.EmployerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class EmployerControler {
    private final EmployerService employerService;
    @GetMapping
            public ResponseEntity getAllEmployer(){return new ResponseEntity(employerService.getAllUsers(), HttpStatus.OK);}

    @PatchMapping
    public ResponseEntity saveEmployer(@RequestBody UserDto userDto){
        return new ResponseEntity(employerService.saveEmployer(userDto),HttpStatus.CREATED);
    }
}

