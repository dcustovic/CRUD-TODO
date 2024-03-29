package com.domo.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.domo.todo.product.Product;
import com.domo.todo.service.ProductService;

@Controller
public class ProductController {
	
	
	@Autowired
	private ProductService service;
	
	
	@RequestMapping("")
	public String viewHome(Model model) {
		List<Product> products = service.listAll();
		model.addAttribute("products", products);
		return "index";
	}
	
	@RequestMapping("/new")
	public String newProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		return "redirect:/";
		
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editProduct(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Optional<Product> product = service.get(id);
		mav.addObject("product", product);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		service.delete(id);
		return "redirect:/";
	}

}
