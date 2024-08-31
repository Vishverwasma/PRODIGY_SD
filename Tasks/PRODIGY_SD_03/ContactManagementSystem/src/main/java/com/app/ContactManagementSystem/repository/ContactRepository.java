package com.app.ContactManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ContactManagementSystem.model.Contact;

public interface ContactRepository extends JpaRepository<Contact,Long> {
	public Contact findByPhone(String phone);
	public Contact findByEmail(String email);
	public List<Contact> findByName(String name);
}
