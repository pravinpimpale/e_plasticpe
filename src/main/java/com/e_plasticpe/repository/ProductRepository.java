package com.e_plasticpe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_plasticpe.entity.Product;

public interface ProductRepository extends JpaRepository<Product , Long>{

}
