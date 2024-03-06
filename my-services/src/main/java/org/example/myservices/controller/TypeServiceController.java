package org.example.myservices.controller;

import lombok.RequiredArgsConstructor;
import org.example.baseservice.dto.MyServiceDto;
import org.example.baseservice.dto.TypeServiceDto;
import org.example.myservices.services.ServiceTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/typeservice")
@RequiredArgsConstructor
public class TypeServiceController {
    private final ServiceTypeService serviceTypeService;
    @GetMapping
    public ResponseEntity getAllTypeService(){return new ResponseEntity(serviceTypeService.getAllTypeService(), HttpStatus.OK);}
    @PatchMapping
    public ResponseEntity saveTypeSercices(@RequestBody TypeServiceDto typeServiceDto){
        return new ResponseEntity(serviceTypeService.saveTypeServices(typeServiceDto),HttpStatus.CREATED);
    }

}
