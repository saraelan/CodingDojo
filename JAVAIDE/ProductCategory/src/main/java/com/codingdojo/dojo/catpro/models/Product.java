package com.codingdojo.dojo.catpro.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
@Entity
@Table(name="products")
public class Product {
@Id
@GeneratedValue
private Long id;

@Size(min=2, max=255)
private String name;

@Size(min=2, max=255)
private String description;

@Min(0)
private float price;

private Date createdAt;

private Date updatedAt;

@ManyToMany(fetch=FetchType.LAZY)
@JoinTable(
    name = "categories_products", 
    joinColumns = @JoinColumn(name = "product_id"), 
    inverseJoinColumns = @JoinColumn(name = "category_id")
)
private List<Category> categories;

public Product() {
    
}

public Product(String name, String description, float price) {
    this.name = name;
    this.description = description;
    this.price = price;  
}

@PrePersist
protected void onCreate() {
	this.createdAt = new Date();
}

@PreUpdate
protected void onUpdate() {
	this.updatedAt = new Date();
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}

public List<Category> getCategories() {
	return categories;
}

public void setCategories(List<Category> categories) {
	this.categories = categories;
}
public void addCategories(Category c) {
	List<Category> cat = this.categories;
	cat.add(c);
	this.setCategories(cat);
}
}