package org.example.myusers.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.baseservice.event.EmployerServiceStatus;
import org.example.baseservice.event.UsersStatus;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employer {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private UUID id;
    private  String nomComplet;
    private  String telephone;
    private String adresse;
    private String  email;
    private String password;
    private UsersStatus userStatus;
    private EmployerServiceStatus emplserviceStatus;
//private String userStatus;
//    private String serviceStatus;
}
