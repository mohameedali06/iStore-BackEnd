package com.iStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iStore.Entity.OrderDetails;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer> {
	OrderDetails findByOrderId(int ordersId);
}
