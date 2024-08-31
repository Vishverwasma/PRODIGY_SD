package com.app.ContactManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ContactManagementSystem.model.Contact;
import com.app.ContactManagementSystem.repository.ContactRepository;
import com.app.ContactManagementSystem.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {
//	@Autowired
//	private final ContactRepository contactRepository;
	@Autowired
	private final ContactService contactService;
	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}
	@GetMapping("/get-all")
	public List<Contact> getAllContacts(){
		return contactService.getAllContacts();
	}
	@GetMapping("/get/{id}")
	public Contact getContactById(@PathVariable Long id) {
		return contactService.getContactById(id);
	}

	@PostMapping("/add")
	public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {
	    Contact createdContact = contactService.addContact(contact);
	    return new ResponseEntity<>(createdContact, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public Contact updateContact(@PathVariable Long id,@RequestBody Contact updateContact) {
		return contactService.updateContact(id, updateContact);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteContactById(@PathVariable Long id) {
		contactService.deleteContact(id);
	}

    @DeleteMapping("/deleteByPhone/{phone}")
    public void deleteContactWithNumber(@RequestBody Contact contact) {
        contactService.deleteContactWithNumber(contact);
    }

    @DeleteMapping("/deleteByEmail/{email}")
    public void deleteContactWithEmail(@RequestBody Contact contact) {
        contactService.deleteContactWithEmail(contact);
    }

    @DeleteMapping("/deleteByName/{name}")
    public void deleteContactWithName(@RequestBody Contact contact) {
        contactService.deleteContactWithName(contact);
    }
}
