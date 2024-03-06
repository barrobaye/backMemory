package org.example.myusers.mapper;

import lombok.RequiredArgsConstructor;
import org.example.baseservice.dto.UserDto;
import org.example.baseservice.event.EmployerServiceStatus;
import org.example.baseservice.event.ServiceStatus;
import org.example.baseservice.event.UsersStatus;
import org.example.myusers.entity.Employer;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployerServiceMapper {
    public UserDto EmployerToUserDto(Employer employer){
        UserDto dto = new UserDto();
        dto.setId(employer.getId());
        dto.setNomComplet(employer.getNomComplet());
        dto.setTelephone(employer.getTelephone());
        dto.setAdresse(employer.getAdresse());
        dto.setEmail(employer.getEmail());
        dto.setPassword(employer.getPassword());
        dto.setUserStatus(employer.getUserStatus().name());
        dto.setEmplserviceStatus((employer.getEmplserviceStatus().name()));
        return dto;
    }

    public Employer UserDtoToEmployer(UserDto userDto){
        return Employer.builder()
                .nomComplet(userDto.getNomComplet())
                .telephone(userDto.getTelephone())
                .adresse(userDto.getAdresse())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .userStatus(UsersStatus.valueOf(userDto.getUserStatus()))
                .emplserviceStatus(EmployerServiceStatus.valueOf(userDto.getEmplserviceStatus()))
                .build();
    }

}
