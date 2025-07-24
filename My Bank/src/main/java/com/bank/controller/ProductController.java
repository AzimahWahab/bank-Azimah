package com.bank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.AccountEntity;

@RestController
@RequestMapping("/api/products/v1")
public class ProductController {

	// TODO: SpringBoot:Practical 8
	// create a new DO Get method to pull all product related to account no
	// account is a passing parameter
	// use swagger to test it
	
	@GetMapping("/by-account-number/{accountNumber}")
	public ResponseEntity<AccountEntity> getByAccountNumber(@PathVariable String accountNumber) {
	    return null;
	}
}
