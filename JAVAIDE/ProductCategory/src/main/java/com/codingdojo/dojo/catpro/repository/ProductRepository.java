package com.codingdojo.dojo.catpro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.codingdojo.dojo.catpro.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
//	List<Product> findAllByCategoriesContaining(Category category);
	List<Product> findAll();
}