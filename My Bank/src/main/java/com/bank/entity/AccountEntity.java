package com.bank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Long accountID;

	@Column(name = "account_number", nullable = false, unique = true)
	private String accountNumber;

	@Column(name = "balance")
	private Double balance;

	// @ManyToOne(optional = false, cascade = {CascadeType.PERSIST,
	// CascadeType.MERGE}) // account must have a customer

	// @ManyToOne(optional = false, cascade = {CascadeType.PERSIST}) // account must
	// have a customer
	
	@ManyToOne(optional = false) // account must have a customer
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerEntity customerEntity;

	@Column(name = "creation_date", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private LocalDateTime creationDate;

	@ManyToMany
	@JoinTable(name = "account_product", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Set<ProductEntity> products = new HashSet<>();

	// Set creationDate to current time if it's null before persisting
	@PrePersist
	protected void onCreate() {
		if (this.creationDate == null) {
			this.creationDate = LocalDateTime.now();
		}
	}
}
