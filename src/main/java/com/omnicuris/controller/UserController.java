package com.omnicuris.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omnicuris.model.Product;
import com.omnicuris.model.User;
import com.omnicuris.repo.ProductRepo;
import com.omnicuris.repo.UserRepo;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ProductRepo productRepo;
	
	@PostMapping("/buy")
	public String addProduct(@RequestBody User user ) {
		int userDemand,productId;
						
		Set<Product> product = user.getProducts();
		for(Product p : product) {
			userDemand=p.getProduct_quantity();
			productId =p.getProduct_Id();
			
			
			Product x =productRepo.findById(productId).get();
			int available = x.getProduct_quantity();
			if (available>=userDemand)
			{
				userRepo.save(user);
				available= available-userDemand;
				x.setProduct_quantity(available);
				x.setProduct_Id(productId);
				x.setProduct_name(p.getProduct_name());
				productRepo.save(x);
			}
			else
				return "Prodocut not available  "+p.getProduct_name();
		}
			
	return "Thanks for purchasing" ;
	}
	
	//AllOrders
	@GetMapping("/allOrders")
	public List<User> allOrders() {
		return userRepo.findAll(); 
	}
	
	
	

}
