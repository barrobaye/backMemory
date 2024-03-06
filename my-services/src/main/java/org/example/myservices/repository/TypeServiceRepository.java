package org.example.myservices.repository;

import org.example.myservices.entity.TypeService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TypeServiceRepository extends JpaRepository <TypeService, UUID>{
    Optional<TypeService> findById(UUID id);


}
