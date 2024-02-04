package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Product;
import com.example.demo.services.ProductService;

import antlr.collections.List;

@RestController
@RequestMapping("product")
public class ProductController 
{
	@Autowired private ProductService service;
	
	@PostMapping("create")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		
		Product p=service.saveProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
	
	
	@GetMapping("productList")
	public ResponseEntity<java.util.List<Product>> getProduct(){
		
		java.util.List<Product> plist=service.getList();
		return ResponseEntity.status(HttpStatus.OK).body(plist);
	}
	
	
	@GetMapping("byid/{pid}")
	public ResponseEntity<Product> getProductById(@PathVariable int pid){
		
		Product product=service.getListById(pid);
		if(product==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(product);
		}	
	}
	
	
	@DeleteMapping("delete/{pid}")
	public ResponseEntity<Product> deleteProduct(@PathVariable int pid){
		
		Product product=service.getListById(pid);
		if(product==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			service.deleteProduct(pid);
			return ResponseEntity.status(HttpStatus.OK).body(product);
		}	
	}
	
	
	@PutMapping("update/{pid}")
	public ResponseEntity<Product> updateProduct(@PathVariable int pid,@RequestBody Product p){
		
		Product product=service.getListById(pid);
		if(product==null) {
			Product pp=service.saveProduct(p);
			return ResponseEntity.status(HttpStatus.CREATED).body(pp);
		}
		else {
			p.setPid(pid);
			product=service.updateProduct(p);
			return ResponseEntity.status(HttpStatus.OK).body(product);
		}	
	}
	
}
