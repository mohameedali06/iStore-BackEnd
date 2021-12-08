package com.iStore.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cart {

	@Id
	@GeneratedValue
	private int cartId;
	private int prodId;
	private int userId;
	private int productNos;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductNos() {
		return productNos;
	}

	public void setProductNos(int productNos) {
		this.productNos = productNos;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", prodId=" + prodId + ", userId=" + userId + ", productNos=" + productNos
				+ "]";
	}

	
}
