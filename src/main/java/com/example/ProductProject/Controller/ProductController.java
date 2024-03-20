package com.example.ProductProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProductProject.Entity.Product;
import com.example.ProductProject.Service.ProductService;
import com.example.ProductProject.utility.ResponseStructure;
@RestController
public class ProductController {
	//@Autowired
private  ProductService ps;
	
	@PostMapping("/products")
	public ResponseEntity<ResponseStructure<Product>> addProduct(@RequestBody Product product) {
		return ps.addProduct(product);
	}
//	@GetMapping(value="/Product/findProductId/{productId}")
//	public ResponseEntity<ResponseStructure<Product>> findByProductId(@PathVariable int productId) {
//		return ps.findProductById(productId);
//	}
	public ProductController(ProductService ps) {
		this.ps=ps;
	}
	public ResponseEntity<ResponseStructure<Product>> findByProductId(@PathVariable int productId) {
		return ps.findProductById(productId);
	}
	
	
	@PutMapping("/products/{productId"
			+ "}")
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(@PathVariable int productId,@RequestBody Product product){
		return ps.updateByProductId(productId, product);
	}
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> deleteProductById(@PathVariable int productId){
		return ps.deleteProductById(productId);
	}
	@GetMapping("/products")
		public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct(){
			return ps.findAllProduct();
		}
	}
	


