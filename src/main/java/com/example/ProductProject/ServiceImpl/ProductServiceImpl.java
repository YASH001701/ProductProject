package com.example.ProductProject.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ProductProject.Entity.Product;
import com.example.ProductProject.Repository.ProductRepository;
//import com.example.ProductProject.Service.List;
import com.example.ProductProject.Service.ProductService;
import com.example.ProductProject.exception.ProductIdNotFoundException;
import com.example.ProductProject.utility.ResponseStructure;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private  ProductRepository pr;
	private ResponseStructure<Product> structure;
	
//	public ProductServiceImpl(
//			ProductRepository pr,
//			ResponseStructure<Product> structure) {
//		super();
//		this.pr=pr;
//	}
		
	

	@Override
	public ResponseEntity<ResponseStructure<Product>> addProduct(Product product) {

		Product products=pr.save(product);
//
//		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
//		responseStructure.setStatusCode(HttpStatus.CREATED.value());
//		responseStructure.setMessage("Product Details Added Successfully");
//		responseStructure.setData(products);
//
	//	return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.CREATED);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseStructure<Product>() 
			
		.setStatusCode(HttpStatus.CREATED.value())
		.setMessage("Product Details Added Successfully")
		.setData(pr.save(product)) );
		
//	public ResponseEntity<ResponseStructure<Product>> addProduct(ProductRequest,productRequest){
		//mapping to entity
	
		
		
	}
	
	
		
	//}
	
	
	@Override
	public ResponseEntity<ResponseStructure<Product>> findProductById(int productId){
//		Optional<Product> opt=pr.findById(productId);
//
//		if(opt.isPresent()) {
//			Product product=opt.get();
//
//			ResponseStructure<Product> responseStructure=new ResponseStructure<>();
//			responseStructure.setStatusCode(HttpStatus.FOUND.value());
//			responseStructure.setMessage("Product Id Found Successfully");
//			responseStructure.setData(product);
//
//			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.FOUND);
//		else {
//			throw new ProductIdNotFoundException("Entered Product Id Is wrong ,Please check");
//		}
		return pr.findById(productId).map(p-> ResponseEntity.ok(structure
				.setStatusCode(HttpStatus.FOUND.value())
				.setMessage("Product object found successfully")
				.setData(p))).orElseThrow(()-> new ProductIdNotFoundException("Entered Product Id Is wrong ,Please check"));
	}
	
	
		
	
	@Override
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId,Product updateProduct){
//		Optional<Product> opt=pr.findById(productId);
//
//		if(opt.isPresent()) {
//			Product existingProduct=opt.get();
//			updateProduct.setProductId(existingProduct.getProductId());
//			pr.save(updateProduct);
//			ResponseStructure<Product> responseStructure=new ResponseStructure<>();
//			responseStructure.setStatusCode(HttpStatus.OK.value());
//			responseStructure.setMessage("product is Updated suceesfully");
//			responseStructure.setData(updateProduct);
//
//			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
//		}
//		else {
//
//			throw new ProductIdNotFoundException("Entered Product Id Is Wrong Plesse check");
//		}

		return pr.findById(productId).map(p->{p.setProductId(p.getProductId());
		Product saveProduct=pr.save(updateProduct);
		
		return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
				.setMessage("Product Message").setData(saveProduct));
		
		
}).orElseThrow(()-> new ProductIdNotFoundException("Entered Product Id Is wrong ,Please check"));

		
	}
	
	
	@Override
	public ResponseEntity<ResponseStructure<Product>> deleteProductById(int productId){
		Optional<Product> opt=pr.findById(productId);

//		if(opt.isPresent()) {
//			Product deleteProduct=opt.get();
//			pr.delete(deleteProduct);
//
//			ResponseStructure<Product> responseStructure=new ResponseStructure<>();
//			responseStructure.setStatusCode(HttpStatus.OK.value());
//			responseStructure.setMessage("Product object deleted Successfully");
//			responseStructure.setData(deleteProduct);
//
//			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
//
//		}
//		else {
//			throw new ProductIdNotFoundException("Entered Product Id Is Wrong Plesse check");
//		}
		return pr.findById(productId).map(deleteProduct->{pr.delete(deleteProduct);return ResponseEntity.ok(new ResponseStructure<Product>()
				.setStatusCode(HttpStatus.OK.value())
				.setMessage("Delete Successfully")
				.setData(deleteProduct));
}).orElseThrow(()-> new ProductIdNotFoundException("The product ur serching does not exist "));

		
	}
	
	
		@Override
		public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct(){
			List<Product> products=pr.findAll();


//			ResponseStructure<List<Product>> responseStructure=new ResponseStructure<>();
//			responseStructure.setStatusCode(HttpStatus.FOUND.value());
//			responseStructure.setMessage("List of Product show Successfully");
//			responseStructure.setData(products);
//
//			return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure,HttpStatus.OK);
ResponseStructure<List<Product>> structure=products.stream()
.collect(Collectors.collectingAndThen(Collectors.toList(),productList->new ResponseStructure<List<Product>>()
		.setStatusCode(HttpStatus.FOUND.value())
		.setMessage("List of product shown successfully")
		.setData(productList)));
return ResponseEntity.ok().body(structure);
		}
	}

