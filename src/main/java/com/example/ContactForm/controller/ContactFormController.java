package com.example.ContactForm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ContactForm.model.User;
import com.example.ContactForm.service.ContactFormService;


@RestController
public class ContactFormController {
	@Autowired
	private ContactFormService contactFormService;
	
	@PostMapping("/addUser")
	public User postDetails(@RequestBody User user) {
	return contactFormService.saveDetails(user);
	
}
	 // GET mapping to fetch all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return contactFormService.getAllUsers();
    }

    // GET mapping to fetch a specific user by ID
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id) {
        return contactFormService.getUserById(id);
    }
	
  //PUT mapping Edit designation
    
    @PutMapping("/users/{id}")
    public User updatedUser(@PathVariable Integer id,@RequestBody User updatedUser) {
		return contactFormService.updatedUser(id,updatedUser);
    	
    }
    
    //Delete Mapping 
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Integer id) {
    	contactFormService.deleteUser(id);
    	 return "User with ID " + id + " has been deleted.";
    }
}
