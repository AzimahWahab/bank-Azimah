package com.bank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity implements Serializable {

	// TODO: SpringBoot:Practical 7.3 - Implement the CRUD services below
	// Implement the CRUD service below
	// ProductController.java
	// IProductService.java
	// ProductServiceImpl.java
	// IProductRepo.java
	
	// Use AccountController as a sample
		
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productID;

    @Column(name = "product_name", nullable = false, unique = true)
    private String productName;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "products")
    private Set<AccountEntity> accounts = new HashSet<>();
}
