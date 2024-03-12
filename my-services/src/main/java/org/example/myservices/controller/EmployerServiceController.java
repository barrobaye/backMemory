package org.example.myservices.controller;

import lombok.RequiredArgsConstructor;
import org.example.baseservice.dto.EmployerServiceDto;
import org.example.baseservice.dto.MyServiceDto;
import org.example.baseservice.event.EmployerEvens;
import org.example.myservices.services.ServiceEmployer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employer")
@RequiredArgsConstructor
public class EmployerServiceController {
    private final ServiceEmployer serviceEmployer;
    @GetMapping
    public ResponseEntity getAllEmployerServices(){return new ResponseEntity(serviceEmployer.getAllEmployerService(), HttpStatus.OK);}

    @PatchMapping
    public ResponseEntity saveEmployerSercices(@RequestBody EmployerEvens employerEvens){
        return new ResponseEntity(serviceEmployer.saveEmployerServices(employerEvens),HttpStatus.CREATED);
    }
}
