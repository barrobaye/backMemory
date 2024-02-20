package org.example.myusers.repository;

import org.example.myusers.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployerRepository extends JpaRepository <Employer, UUID> {

}
