package com.example.ContactForm.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ContactForm.model.User;
import com.example.ContactForm.repository.ContactFormRepo;

@Service
public class ContactFormService {
	
	@Autowired
	private ContactFormRepo contactFormRepo;
	
	public User saveDetails(User user) {
	user.setDateCreated(LocalDate.now());
	User saveUser= contactFormRepo.save(user);
     return saveUser;
	//return contactFormRepo.save(user);
	
	}
	
	public List<User> getAllUsers() {
		
		return contactFormRepo.findAll();
	}

//	public User getUserById(Integer id) {
//		Optional<User>	listUser=contactFormRepo.findById(id);
//		
//		if(listUser.isPresent()) {
//			return listUser;
//		
//		}else {
//			throw new IllegalArgumentException("User not found with ID: " + id);
//		}
//		
//	}
	
//  Retrieve user by ID
	public User getUserById(Integer id) {
		
		 Optional<User> user = contactFormRepo.findById(id);
		
		return user.orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
	}
	
	//Edit designation
	
	public User updatedUser(Integer id, User updatedUser) {
		Optional<User>	listUser=contactFormRepo.findById(id);
		if(listUser.isPresent()) {
	User existingUser=listUser.get();
	existingUser.setDesignation(updatedUser.getDesignation());
	contactFormRepo.save(existingUser);
		}
		else {
			System.out.println("User not Found:"+id );
		}
		return updatedUser;
	}

	public void deleteUser(Integer id) {
		
		if(contactFormRepo.existsById(id)) {
		contactFormRepo.deleteById(id);
		}else {
			throw new IllegalArgumentException("User not Found with ID"+id);
		}
	}
	

}
