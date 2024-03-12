package org.example.myservices.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.baseservice.dto.MyServiceDto;
import org.example.baseservice.dto.TypeServiceDto;
import org.example.myservices.entity.MyServices;
import org.example.myservices.entity.TypeService;
import org.example.myservices.mapper.TypeServiceMapper;
import org.example.myservices.repository.TypeServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Data
@Slf4j
public class ServiceTypeService {
    private final TypeServiceRepository typeServiceRepository;
    private final TypeServiceMapper mapper;
    public List<TypeServiceDto> getAllTypeService(){
        return typeServiceRepository.findAll().stream().map(mapper::TypeServiceToTypeServiceDto).collect(Collectors.toList());
    }
    public TypeService saveTypeServices(TypeServiceDto typeServiceDto){
        TypeService typeService = typeServiceRepository.save(mapper.TypeServiceDtoToTypeService(typeServiceDto));
        typeServiceDto.setId(typeService.getId());
        return typeService;
    }
}
