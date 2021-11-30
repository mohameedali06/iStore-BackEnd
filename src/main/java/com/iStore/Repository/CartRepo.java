package com.iStore.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iStore.Entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {
	List<Cart> findAllByUserId(int userId);
}
