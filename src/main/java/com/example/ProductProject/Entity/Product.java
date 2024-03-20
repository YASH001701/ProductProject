package com.example.ProductProject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product{
@Id
private int productId;
private int productPrice;
private String productName;
private String productBrand;

//public int getProductId() {
//	return productId;
//}
//public void setProductId(int productId) {
//	this.productId = productId;
//}
//public int getProductPrice() {
//	return productPrice;
//}
//public void setProductPrice(int productPrice) {
//	this.productPrice = productPrice;
//}
//public String getProductName() {
//	return productName;
//}
//public void setProductName(String productName) {
//	this.productName = productName;
//}
//public String getProductBrand() {
//	return productBrand;
//}
//public void setProductBrand(String productBrand) {
//	this.productBrand = productBrand;
//}
}
