package org.example.myservices.repository;

import org.example.myservices.entity.EmployerService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EmployerServiceRepository extends JpaRepository<EmployerService, UUID> {

}
