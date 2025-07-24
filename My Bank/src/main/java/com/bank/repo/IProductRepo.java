package com.bank.repo;

import com.bank.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends JpaRepository<ProductEntity, Long> {
    boolean existsByProductName(String productName);
}
