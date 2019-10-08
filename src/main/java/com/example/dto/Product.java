package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product {

	private int productId;
	@Size(min=5, max=10,message="Product Min lenght is 5 and not more than 10")
	private String productName;
	private String productVender;
	private Double productPrice;
	private String productInStock;	
	private long productCode;
    Product_details details;	
	
	
	public Product_details getDetails() {
		return details;
	}
	public void setDetails(Product_details details) {
		this.details = details;
	}
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
	public String getProductVender() {
		return productVender;
	}
	public void setProductVender(String productVender) {
		this.productVender = productVender;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductInStock() {
		return productInStock;
	}
	public void setProductInStock(String productInStock) {
		this.productInStock = productInStock;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productVender=" + productVender
				+ ", productPrice=" + productPrice + ", productInStock=" + productInStock + "]";
	}
	public long getProductCode() {
		return productCode;
	}
	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}
	
	
}
