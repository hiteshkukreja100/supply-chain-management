package com.scm.scm_backend.repository;  // Adjust based on your package structure

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.scm.scm_backend.entity.Shipment;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    // Custom query methods can be added here if needed
}

