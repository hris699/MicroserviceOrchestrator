package com.example.demo.repository;

import com.example.demo.model.ServiceRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ServiceRegistryRepository extends JpaRepository<ServiceRegistry, Long> {
   Optional<ServiceRegistry> findByServiceName(String serviceName);
}