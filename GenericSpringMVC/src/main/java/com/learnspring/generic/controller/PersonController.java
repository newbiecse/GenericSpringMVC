package com.learnspring.generic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learnspring.generic.model.Person;
import com.learnspring.generic.service.interfaces.PersonService;

@Controller
public class PersonController {
	private PersonService personService;
	
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.findAll());
		return "/person/person";
	}
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		
		if(p.getId() == 0){
			//new person, add it
			this.personService.add(p);
		}else{
			//existing person, call update
			this.personService.update(p);
		}
		
		return "redirect:/persons";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.delete(id);
        return "redirect:/persons";
    }
 
    @RequestMapping("/edit/{nameId}")
    public String editPerson(@PathVariable("nameId") int abc, Model model){
        model.addAttribute("person", this.personService.getById(abc));
        model.addAttribute("listPersons", this.personService.findAll());
        return "person";
    }
}
