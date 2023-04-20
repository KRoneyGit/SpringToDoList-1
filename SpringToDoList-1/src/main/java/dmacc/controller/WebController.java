package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.ToDoItem;
import dmacc.repository.ToDoItemRepository;

/**
* @author Kevin Roney - karoney
* CIS 175 - Fall 2023
* Mar 21, 2023
*/
@Controller
public class WebController {
	@Autowired
	ToDoItemRepository repo;
	
	@GetMapping({ "/", "/viewAll"})
	public String viewAllItems(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewItem(model);
		}
		model.addAttribute("todo", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputItem")
	public String addNewItem(Model model) {
		ToDoItem todo = new ToDoItem();
		model.addAttribute("newItem", todo);
		return "input";
	}
	
	@PostMapping("/inputItem")
	public String addNewItem(@ModelAttribute ToDoItem todo, Model model) {
		repo.save(todo);
		return viewAllItems(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateItem(@PathVariable("id") long id, Model model) {
		ToDoItem todo = repo.findById(id).orElse(null);
		model.addAttribute("newItem", todo);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String reviseItem(ToDoItem todo, Model model) {
		repo.save(todo);
		return viewAllItems(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteItem(@PathVariable("id") long id, Model model) {
		ToDoItem todo = repo.findById(id).orElse(null);
		repo.delete(todo);
		return viewAllItems(model);
	}
}
