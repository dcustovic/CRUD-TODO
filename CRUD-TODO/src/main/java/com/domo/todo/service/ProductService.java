package com.domo.todo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.domo.todo.product.Product;
import com.domo.todo.repository.ProductRepository;


@Service
public class ProductService {
	
	
	@Autowired
	private ProductRepository repo;
	
	
	public Optional<Product> get(Long id) {
		return repo.findById(id);
	}
	
	public List<Product> listAll() {
		return repo.findAll();
	}
	
	public void save(Product product) {
		repo.save(product);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
