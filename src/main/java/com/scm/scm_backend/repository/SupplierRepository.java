package com.scm.scm_backend.repository;  // Adjust based on your package structure

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.scm.scm_backend.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    // Custom query methods can be added here if needed
}
 
