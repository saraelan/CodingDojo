package com.codingdojo.dojo.catpro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.dojo.catpro.models.Category;
import com.codingdojo.dojo.catpro.models.Product;
import com.codingdojo.dojo.catpro.service.CatproService;


@Controller
public class CatproController {
private final CatproService catproService;
public CatproController(CatproService catproService)
{
	this.catproService=catproService;
}

@RequestMapping("/")
public String index(Model model)
{
	return "index.jsp";
}
	
@RequestMapping("/products/new")
public String newProduct(@ModelAttribute("product") Product product,Model model) 
// List<Product> products =catproService.allProducts();
//	model.addAttribute("products",products);
{
    return "addp.jsp";
}

@RequestMapping(value="/products/new", method=RequestMethod.POST)
public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
    if (result.hasErrors()) {
        return "addp.jsp";
    } else {
        catproService.createProduct(product);
        return "redirect:/";
    }
}

@RequestMapping("/categories/new")
public String newCategory(@ModelAttribute("category") Category category,Model model) 
{   
//	List<Category> categories =catproService.allCategories();
//	model.addAttribute("categories",categories);
    return "addc.jsp";
}

@RequestMapping(value="/categories/new", method=RequestMethod.POST)
public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {
    if (result.hasErrors()) {
        return "addc.jsp";
    } else {
        catproService.createCategory(category);
        return "redirect:/";
    }
}

@RequestMapping(value="/categories/{id}", method=RequestMethod.GET)
public String showc(Model model, @PathVariable("id") Long id ) {
	Category category  = catproService.findCategory(id);
	model.addAttribute("category", category);
	List<Product> products = catproService.allProducts();
	model.addAttribute("products", products);

	return "cat.jsp";
}

@RequestMapping(value="/products/{id}", method=RequestMethod.GET)
public String showp(Model model, @PathVariable("id") Long id ) {
	Product product  = catproService.findProduct(id);
	model.addAttribute("product",product);
	List<Category> categories = catproService.allCategories();
	model.addAttribute("categories",categories);
	return "pro.jsp";
}

@RequestMapping(value="/categories/{id}/add", method=RequestMethod.POST)
public String showc(@RequestParam(value="product") Long p, @PathVariable("id") Long id )
{
catproService.updateCategory(id,p);
return "redirect:/categories/"+id;

}
@RequestMapping(value="/products/{id}/add", method=RequestMethod.POST)
public String showp(@RequestParam(value="category") Long p, @PathVariable("id") Long id )
{
catproService.updateProduct(id, p);
return "redirect:/products/"+id;

}

}
