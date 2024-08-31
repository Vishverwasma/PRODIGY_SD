package com.app.ContactManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ContactManagementSystem.model.Contact;
import com.app.ContactManagementSystem.repository.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;
	
	public List<Contact> getAllContacts(){
		return contactRepository.findAll();
	}
	public Contact getContactById(Long id) {
		return contactRepository.findById(id).orElse(null);
	}
	public Contact addContact(Contact contact) {
		return contactRepository.save(contact);
	}
	public Contact updateContact(Long id,Contact updatedContact) {
		Optional<Contact> existingContactOpt = contactRepository.findById(id);
		if(existingContactOpt.isPresent()) {
			Contact existingContact = existingContactOpt.get();
			existingContact.setName(updatedContact.getName());
			existingContact.setPhone(updatedContact.getPhone());
			existingContact.setEmail(updatedContact.getEmail());
			return contactRepository.save(existingContact);
		}
		return null;
	}
	public void deleteContact(Long id) {
		contactRepository.deleteById(id);
	}
	public void deleteContactWithNumber(Contact contact) {
		Contact existingContact = contactRepository.findByPhone(contact.getPhone());
		if(existingContact != null) {
			contactRepository.delete(existingContact);
			System.out.println("Contact with Phone Number "+contact.getPhone()+" is deleted successfully ! ");
		} else {
			System.out.println("No contact found with phone number " + contact.getPhone());
			
		}
    }

    public void deleteContactWithEmail(Contact contact) {
        Contact existingContact = contactRepository.findByEmail(contact.getEmail());
        if (existingContact != null) {
            contactRepository.delete(existingContact);
            System.out.println("Contact with email " + contact.getEmail() + " has been deleted.");
        } else {
            System.out.println("No contact found with email " + contact.getEmail());
        }
    }

    public void deleteContactWithName(Contact contact) {
        List<Contact> contactsWithName = contactRepository.findByName(contact.getName());
        if (!contactsWithName.isEmpty()) {
            contactRepository.deleteAll(contactsWithName);
            System.out.println("Contact(s) with name " + contact.getName() + " have been deleted , that is number of Contacts deleted is : " + contactsWithName.size());
        } else {
            System.out.println("No contact found with name " + contact.getName());
        }
    }
}
