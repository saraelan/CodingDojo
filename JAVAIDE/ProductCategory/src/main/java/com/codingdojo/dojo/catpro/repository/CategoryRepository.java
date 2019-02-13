package com.codingdojo.dojo.catpro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojo.catpro.models.Category;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
//	List<Category> findAllByProductsContaining(Product product);
	List<Category> findAll();
}
