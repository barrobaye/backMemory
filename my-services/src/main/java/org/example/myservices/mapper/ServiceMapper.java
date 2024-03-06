package org.example.myservices.mapper;

import lombok.RequiredArgsConstructor;
import org.example.baseservice.dto.MyServiceDto;
import org.example.baseservice.event.ServiceStatus;
import org.example.myservices.entity.MyServices;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServiceMapper {
    public MyServiceDto MyserviceToMyServiceDto(MyServices myServices){
        return MyServiceDto.builder()
                .id(myServices.getId())
                .typeService(myServices.getTypeService())
                .status(myServices.getStatus().name())
                .build();
    }
    public MyServices MyserviceDtoToService(MyServiceDto myServiceDto){
        return MyServices.builder()
                .id(myServiceDto.getId())
                .typeService(myServiceDto.getTypeService())
                .status(ServiceStatus.valueOf(myServiceDto.getStatus()))
                .build();
    }
}
