package org.example.myservices.mapper;

import lombok.RequiredArgsConstructor;
import org.example.baseservice.dto.MyServiceDto;
import org.example.baseservice.dto.TypeServiceDto;
import org.example.myservices.entity.MyServices;
import org.example.myservices.entity.TypeService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TypeServiceMapper {
    public TypeServiceDto TypeServiceToTypeServiceDto(TypeService typeService){
        return TypeServiceDto.builder()
                .id(typeService.getId())
                .libelle(typeService.getLibelle())
                .build();
    }
    public TypeService TypeServiceDtoToTypeService(TypeServiceDto typeServiceDto){
        return TypeService.builder()
                .id(typeServiceDto.getId())
                .libelle(typeServiceDto.getLibelle())
                .build();
    }

}
