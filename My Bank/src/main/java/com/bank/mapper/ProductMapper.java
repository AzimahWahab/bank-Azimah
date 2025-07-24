package com.bank.mapper;

import com.bank.entity.ProductEntity;
import com.bank.model.ProductDTO;
import org.mapstruct.Mapper;

// TODO: SpringBoot:Practical 7.2 - create a mapper class and mapper test class ProductMapperTest.java for Product entity
// Use CustomerMapper.java as reference

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductDTO toDto(ProductEntity entity);

    ProductEntity toEntity(ProductDTO dto);

    List<ProductDTO> toDtoList(List<ProductEntity> entityList);

    List<ProductEntity> toEntityList(List<ProductDTO> dtoList);
}