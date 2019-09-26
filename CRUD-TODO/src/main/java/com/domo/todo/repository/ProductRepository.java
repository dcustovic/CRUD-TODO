package com.domo.todo.repository;


import com.domo.todo.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long> {
	

}
 