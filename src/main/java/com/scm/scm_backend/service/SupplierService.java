package com.scm.scm_backend.service;  // Adjust based on your package structure

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.scm.scm_backend.entity.Supplier;
import com.scm.scm_backend.repository.SupplierRepository;

import jakarta.transaction.Transactional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;
    
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
    
    @Transactional 
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Optional<Supplier> getSupplierById(Long id) {
        return supplierRepository.findById(id);
    }

    // Other business logic for Supplier entity
}
 
