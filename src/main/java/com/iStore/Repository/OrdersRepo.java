package com.iStore.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iStore.Entity.Orders;

public interface OrdersRepo extends JpaRepository<Orders, Integer> {
	List<Orders> findAllByUserId(int userId);
}
