package org.example.myservices.controller;

import lombok.RequiredArgsConstructor;
import org.example.baseservice.dto.MyServiceDto;
import org.example.baseservice.dto.UserDto;
import org.example.myservices.services.ServiceSrvs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class MyServiceController {
    private final ServiceSrvs serviceSrvs;
    @GetMapping
    public ResponseEntity getAllMyServices(){return new ResponseEntity(serviceSrvs.getAllServices(), HttpStatus.OK);}
    @PatchMapping
    public ResponseEntity saveMySercices(@RequestBody MyServiceDto myServiceDto) throws Exception {
        return new ResponseEntity(serviceSrvs.saveServices(myServiceDto),HttpStatus.CREATED);
    }

}
