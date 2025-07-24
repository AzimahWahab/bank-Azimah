package com.bank.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	
    private Long productID;
    private String productCode;
    private String productName;
    private String productType;
    private String description;
    private BigDecimal price;
    private LocalDateTime creationDate;
    
}
