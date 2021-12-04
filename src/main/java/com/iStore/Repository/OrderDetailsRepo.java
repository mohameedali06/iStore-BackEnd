package com.iStore.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iStore.Entity.OrderDetails;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer> {
	List<OrderDetails> findAllByOrderId(int ordersId);
}
