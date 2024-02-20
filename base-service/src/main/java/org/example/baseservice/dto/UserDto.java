package org.example.baseservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private UUID id;
    private  String nomComplet;
    private  String telephone;
    private String  email;
    private String password;
    private String adresse;
    private String userStatus;
    private String serviceStatus;
}
