package com.example.ContactForm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ContactForm.model.User;

public interface ContactFormRepo extends JpaRepository<User, Integer> {

}
