package org.example.myservices.repository;

import org.example.myservices.entity.MyServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MyServiceRepository extends JpaRepository<MyServices, UUID> {

}
