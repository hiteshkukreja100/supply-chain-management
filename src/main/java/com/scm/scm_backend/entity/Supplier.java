package com.scm.scm_backend.entity;



import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.List;

// If using Lombok for simplifying Getters, Setters, and Constructors
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "suppliers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "supplier_id")
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "performance_rating")
    private BigDecimal performanceRating;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;  // A supplier can have multiple products

//	public String getName() {
//		// TODO Auto-generated method stub
//		return name;
//	}
}
