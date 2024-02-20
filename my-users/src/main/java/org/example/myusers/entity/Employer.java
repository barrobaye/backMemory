package org.example.myusers.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.baseservice.event.ServiceStatus;
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
//    ALTER COLUMN userStatus TYPE smallint
//    USING service_status::smallint;
    private UsersStatus userStatus;
    private ServiceStatus serviceStatus;
//private String userStatus;
//    private String serviceStatus;
}
