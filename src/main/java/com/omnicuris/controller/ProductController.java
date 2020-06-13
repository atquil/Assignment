package com.omnicuris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omnicuris.model.Product;
import com.omnicuris.repo.ProductRepo;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	ProductRepo productReop;
	
	@PostMapping("/addproduct")
	public String addProduct(@RequestBody Product product ) {
		
		
		productReop.save(product);
		return "Product Created";
	}
	
	@GetMapping("/getAll")
	public List<Product> getAllProd() {
		List<Product> products =productReop.findAll();
		return products;
	}

	@PutMapping("/update/{Id}")
	public String updateProd(@RequestBody Product product,@PathVariable int Id) {
		Product products1 = new Product();
		products1.setProduct_Id(Id);
		products1.setProduct_name(product.getProduct_name());
		products1.setProduct_quantity(product.getProduct_quantity());
		productReop.save(products1);
		return "Product with Id : "+Id + " Updated";
	}

	@DeleteMapping("/delete/{Id}")
	public String deleteProd(@PathVariable int Id) {
		
		productReop.deleteById(Id);
		return "Product with Id : "+Id+ " Deleted";
	}
}
