package org.example.myservices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.baseservice.event.ServiceStatus;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MyServices {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private UUID id;
    private UUID typeService;
    private ServiceStatus status;
}
