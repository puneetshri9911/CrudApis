package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService 
{
		@Autowired private ProductRepository repo;

	public Product saveProduct(Product product) {
		
		return repo.save(product);	
	}

	public List<Product> getList() {
		
		return repo.findAll();
	}

	public Product getListById(int pid) {
		
		return repo.findById(pid).orElse(null);
	}

	public void deleteProduct(int pid) {
		repo.deleteById(pid);
		
	}

	public Product updateProduct(Product product) {
		
		return repo.save(product);
	}


	
	
	
}
