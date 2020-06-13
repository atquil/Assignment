package com.omnicuris.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="products")
public class Product {


@Id
 @Column(name="product_Id")
 private int product_Id;

 @Column(name="product_name")
 private String product_name;
 
 @Column(name="product_quantity")
 private int product_quantity;

 public int getProduct_quantity() {
	return product_quantity;
}

public void setProduct_quantity(int product_quantity) {
	this.product_quantity = product_quantity;
}

//@ManyToMany(mappedBy = "products")
// private Set<User> users= new HashSet<>();

 
 public int getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	/*
	 * public Set<User> getUsers() { return users; }
	 * 
	 * public void setUsers(Set<User> users) { this.users = users; }
	 */
 
}