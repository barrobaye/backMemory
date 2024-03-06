package org.example.myservices.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.baseservice.event.EmployerServiceStatus;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class EmployerService {
    @Id
    private UUID employer_id;
    private UUID myServices;
    private EmployerServiceStatus employerServiceStatus;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

}
