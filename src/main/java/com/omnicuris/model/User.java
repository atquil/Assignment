package com.omnicuris.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//If getting the Error in JoinColumn use this
import javax.persistence.JoinColumn;

@Entity
@Table(name = "user")
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int user_Id;

@Column(name = "email")
private String email;

@Column(name = "name")
private String name; 

@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
@JoinTable(name="user_product", 
    joinColumns=@JoinColumn(name="user_Id"),
    inverseJoinColumns=@JoinColumn(name="product_Id"))
private Set<Product> products  = new HashSet<>();

public int getUser_Id() {
	return user_Id;
}

public void setUser_Id(int user_Id) {
	this.user_Id = user_Id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Set<Product> getProducts() {
	return products;
}

public void setProducts(Set<Product> products) {
	this.products = products;
}

 
}