package com.learnspring.generic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learnspring.generic.model.Product;
import com.learnspring.generic.service.interfaces.ProductService;

@Controller
@RequestMapping(value= "/products")
public class ProductController {
	
	private ProductService productService;
	
	@Autowired(required=true)
	@Qualifier(value="productService")
	public void setProductService(ProductService ps){
		this.productService = ps;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("product", new Product());
		List<Product> listProduct = this.productService.findAll();
		model.addAttribute("listProduct", listProduct);
		return "/product/product";
	}
	
	//For add and update person both
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("product") Product p){
		
		if(p.getId() == 0){
			//new person, add it
			this.productService.add(p);
		}else{
			//existing person, call update
			this.productService.update(p);
		}
		
		return "redirect:/products";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id") int id){
		
        this.productService.delete(id);
        return "redirect:/products";
    }
	
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("product", this.productService.getById(id));
        model.addAttribute("listProduct", this.productService.findAll());
        return "product/product";
    }	
}
