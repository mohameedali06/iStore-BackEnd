package com.iStore.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderDetails {

	@Id
	@GeneratedValue
	private int id;
	private int orderId;
	private int productId;
	private int productNos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductNos() {
		return productNos;
	}

	public void setProductNos(int productNos) {
		this.productNos = productNos;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", orderId=" + orderId + ", productId=" + productId + ", productNos="
				+ productNos + "]";
	}
	
}
