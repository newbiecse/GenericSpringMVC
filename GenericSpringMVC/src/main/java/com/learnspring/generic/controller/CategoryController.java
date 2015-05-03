package com.learnspring.generic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learnspring.generic.model.Category;
import com.learnspring.generic.model.Product;
import com.learnspring.generic.service.interfaces.CategoryService;

@Controller
@RequestMapping(value= "/categories")
public class CategoryController extends BaseController {
	
	private CategoryService categoryService;
	
	@Autowired(required=true)
	@Qualifier(value="categoryService")
	public void setCategoryService(CategoryService ps){
		this.categoryService = ps;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("category", new Product());
		List<Category> listCategory = this.categoryService.findAll();
		model.addAttribute("listCategory", listCategory);
		logger.info("List Product: ");
		return "/category/category";
	}
	
	//For add and update person both
	@RequestMapping(value= "/add", method = RequestMethod.POST)
//	public String add(@ModelAttribute("product") Product p){
	public String add(@Valid Category c, BindingResult bindingResult){
		
		if (bindingResult.hasErrors()) {
			return "/product/productErrors";
	    }
		
		if(c.getId() == 0){
			//new person, add it
			this.categoryService.add(c);
		}else{
			//existing person, call update
			this.categoryService.update(c);
		}
		
		return "redirect:/categories";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id") int id){
		
        this.categoryService.delete(id);
        return "redirect:/categories";
    }
	
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("category", this.categoryService.getById(id));
        model.addAttribute("listCategory", this.categoryService.findAll());
        return "category/category";
    }	
}
