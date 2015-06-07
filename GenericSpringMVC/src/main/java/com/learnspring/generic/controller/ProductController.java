package com.learnspring.generic.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learnspring.generic.model.Category;
import com.learnspring.generic.model.Product;
import com.learnspring.generic.service.interfaces.CategoryService;
import com.learnspring.generic.service.interfaces.ProductService;

@Controller
@RequestMapping(value= "/products")
public class ProductController extends BaseController {
	
	private ProductService productService;
	private CategoryService categoryService;
	
	@Autowired(required=true)
	@Qualifier(value="categoryService")	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Autowired(required=true)
	@Qualifier(value="productService")
	public void setProductService(ProductService ps){
		this.productService = ps;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("product", new Product());
		List<Product> listProduct = this.productService.findAll();
		List<Category> listCategory = this.categoryService.findAll();
//		Map< String, String > categories = new LinkedHashMap<string, string>();  
		model.addAttribute("listProduct", listProduct);
		
		Map referenceData = new HashMap();
		Map<String,String> categories = new LinkedHashMap<String,String>();
		for(Category c : listCategory) {
			categories.put(c.getId() + "", c.getName());
		}
		model.addAttribute("categories", categories);
		
		return "/product/product";
	}
	
	@RequestMapping(value= "/add", method = RequestMethod.POST)
//	public @ResponseBody Product add(@RequestBody @ModelAttribute Product p, BindingResult bindingResult,
	public @ResponseBody Product add(@ModelAttribute Product p, BindingResult bindingResult,
			 Model model,
		        @ModelAttribute("category") Category category){
		
//		if (bindingResult.hasErrors()) {
//			return "/product/productErrors";
//	    }
		
		if(p.getId() == 0){
			//new person, add it
			this.productService.add(p);
		}else{
			//existing person, call update
			this.productService.update(p);
		}
		
//		Product p1 = new Product();
//		p1.setId(1);
//		p1.setName("new product");
////		Category c1 = this.categoryService.getById(2);
////		p1.setCategory(c1);
//		Category c1 = this.categoryService.getById(2);
//		c1.setProduct(null);
//		p1.setCategory(c1);

		
		return p;
//		return p1;
		
	}	
	
	//For add and update person both
//	@RequestMapping(value= "/add", method = RequestMethod.POST)
//	public String add(@ModelAttribute Product p, BindingResult bindingResult,
//			 Model model,
//		        @ModelAttribute("category") Category category){
//		
//		if (bindingResult.hasErrors()) {
//			return "/product/productErrors";
//	    }
//		
//		if(p.getId() == 0){
//			//new person, add it
//			this.productService.add(p);
//		}else{
//			//existing person, call update
//			this.productService.update(p);
//		}
//		
//		return "redirect:/products";
//		
//	}
	
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
