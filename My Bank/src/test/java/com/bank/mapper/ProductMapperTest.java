package com.bank.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.entity.ProductEntity;
import com.bank.model.ProductDTO;

@SpringBootTest
public class ProductMapperTest {

	@Autowired
    private ProductMapper productMapper;
	
	@Test
	void testEntityToDtoAndBack() {
		// Create sample ProductEntity 
		ProductEntity product = new ProductEntity();
		product.setProductID(1L);
		product.setDescription("sedap");
		product.setProductName("Ubat Gigi DHerbs");
		
		//Convert to DTO 
		ProductDTO dto = productMapper.toDto(product);
		
		assertNotNull(dto);
		assertNotNull(dto.getProductID()); 
	}
}