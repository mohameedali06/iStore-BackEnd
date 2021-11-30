package com.iStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iStore.Entity.Products;

public interface ProductsRepo extends JpaRepository<Products, Integer> {

}
