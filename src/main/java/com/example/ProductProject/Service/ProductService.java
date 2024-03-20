package com.example.ProductProject.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ProductProject.Entity.Product;
import com.example.ProductProject.utility.ResponseStructure;
@Service
public interface ProductService {
	
	public abstract ResponseEntity<ResponseStructure<Product>> addProduct(Product product);
	
	public ResponseEntity<ResponseStructure<Product>> findProductById(int productId);
	
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId, Product updateProduct);
	
	public ResponseEntity<ResponseStructure<Product>> deleteProductById(int productId);
	
	public ResponseEntity<ResponseStructure<List <Product>>> findAllProduct();
	

	//public abstract ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId);
}
