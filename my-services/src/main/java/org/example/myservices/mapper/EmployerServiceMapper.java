package org.example.myservices.mapper;

import lombok.RequiredArgsConstructor;
import org.example.baseservice.dto.EmployerServiceDto;
import org.example.myservices.entity.EmployerService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployerServiceMapper {
    public EmployerServiceDto EmplServToEmplServDTO(EmployerService employerService){
        return EmployerServiceDto.builder()
                .employer_id(employerService.getEmployer_id())
                .service_id(employerService.getMyServices())
                .dateCreation(employerService.getDateCreation())
                .build();
    }
}
