package com.iStore.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Products {

	@Id
	@GeneratedValue
	private int productId;
	private String productName;
	private double productPrice;
	private String productDesc;
	private String productImgSrc1;
	private String productImgSrc2;
	private String productImgSrc3;
	private String productImgSrc4;
	private String productImgSrc5;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductImgSrc1() {
		return productImgSrc1;
	}

	public void setProductImgSrc1(String productImgSrc1) {
		this.productImgSrc1 = productImgSrc1;
	}

	public String getProductImgSrc2() {
		return productImgSrc2;
	}

	public void setProductImgSrc2(String productImgSrc2) {
		this.productImgSrc2 = productImgSrc2;
	}

	public String getProductImgSrc3() {
		return productImgSrc3;
	}

	public void setProductImgSrc3(String productImgSrc3) {
		this.productImgSrc3 = productImgSrc3;
	}

	public String getProductImgSrc4() {
		return productImgSrc4;
	}

	public void setProductImgSrc4(String productImgSrc4) {
		this.productImgSrc4 = productImgSrc4;
	}

	public String getProductImgSrc5() {
		return productImgSrc5;
	}

	public void setProductImgSrc5(String productImgSrc5) {
		this.productImgSrc5 = productImgSrc5;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDesc=" + productDesc + ", productImgSrc1=" + productImgSrc1 + ", productImgSrc2="
				+ productImgSrc2 + ", productImgSrc3=" + productImgSrc3 + ", productImgSrc4=" + productImgSrc4
				+ ", productImgSrc5=" + productImgSrc5 + "]";
	}

	

}
