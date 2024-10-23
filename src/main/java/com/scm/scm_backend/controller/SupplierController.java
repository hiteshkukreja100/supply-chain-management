package com.scm.scm_backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.scm.scm_backend.entity.Supplier;
import com.scm.scm_backend.service.SupplierService;

@RestController
@RequestMapping("/api/suppliers")
@CrossOrigin(origins = "http://localhost:3000") 
public class SupplierController {
	private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @PostMapping
    public ResponseEntity<?> addSupplier(@RequestBody Supplier supplier) {
        logger.info("Received supplier: {}", supplier);
        
        if (supplier.getName() == null || supplier.getName().trim().isEmpty()) {
            logger.error("Supplier name is null or empty");
            return ResponseEntity.badRequest().body("Supplier name cannot be null or empty");
        }

        try {
            Supplier savedSupplier = supplierService.saveSupplier(supplier);
            logger.info("Saved supplier: {}", savedSupplier);
            return ResponseEntity.ok(savedSupplier);
        } catch (Exception e) {
            logger.error("Error saving supplier", e);
            return ResponseEntity.internalServerError().body("Error saving supplier: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        return supplierService.getSupplierById(id)
                .map(supplier -> ResponseEntity.ok().body(supplier))
                .orElse(ResponseEntity.notFound().build());
    }

    // Other supplier-related API endpoints can be added here
}
