package com.codingdojo.dojo.catpro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojo.catpro.models.Category;
import com.codingdojo.dojo.catpro.models.Product;
import com.codingdojo.dojo.catpro.repository.CategoryRepository;
import com.codingdojo.dojo.catpro.repository.ProductRepository;






@Service
public class CatproService {

	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	
	public CatproService(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository=categoryRepository;
		this.productRepository=productRepository;
	}
	
	 public List<Product> allProducts() {
	        return productRepository.findAll();
	 }
	 public List<Category> allCategories() {
	        return categoryRepository.findAll();
	 }
	 
	 public Product createProduct(Product p) {
	        return productRepository.save(p);
	    }
	 public Category createCategory(Category c) {
	        return categoryRepository.save(c);
	    }
	 
	 public Product findProduct(Long id) {
	        Optional<Product> optionalProduct = productRepository.findById(id);
	        if(optionalProduct.isPresent()) {
	            return optionalProduct.get();
	        } else {
	            return null;
	        }
	    }
	 
	 public Category findCategory(Long id) {
	        Optional<Category> optionalCategory =categoryRepository.findById(id);
	        if(optionalCategory.isPresent()) {
	            return optionalCategory.get();
	        } else {
	            return null;
	        }
	    }
	 
//	 public List<Category> getCategoriesOfProduct(Product product) {
//			return categoryRepository.findAllByProductsContaining(product);
//		}
//	 
//	 public List<Product> getProductsOfCategory(Category category) {
//			return productRepository.findAllByCategoriesContaining(category);
//		}
	 
		public void updateProduct(Long id,Long cid) {
			Optional<Product> optionalProduct = productRepository.findById(id);
			if(optionalProduct.isPresent()) 
			{	System.out.println("Hi");
				Optional<Category> optionalCategory =categoryRepository.findById(cid);
				optionalProduct.get().addCategories(optionalCategory.get());
				productRepository.save(optionalProduct.get());
		    
				
			}
			

}
			public void updateCategory(Long id,Long pid) {
			Optional<Category> optionalCategory = categoryRepository.findById(id);
			if(optionalCategory.isPresent()) 
			{	System.out.println("Hi");
				Optional<Product> optionalProduct = productRepository.findById(pid);
				optionalCategory.get().addProducts(optionalProduct.get());
				categoryRepository.save(optionalCategory.get());
				
		    
				
			}
			
			

}
}

