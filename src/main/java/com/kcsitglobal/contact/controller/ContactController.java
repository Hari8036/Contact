package com.kcsitglobal.contact.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kcsitglobal.contact.model.Contact;
import com.kcsitglobal.contact.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ContactService contactService;

	@GetMapping("/get-contacts")
	public Object getContacts() {
		@SuppressWarnings("unchecked")
		List<Contact> contact = (List<Contact>) contactService.getContacts();
		logger.info(contact.toString());
		return contact;
	}

	@GetMapping("/get-contactId")
	public Object getContactById(@RequestParam int id) {
		Object contact = contactService.getContactById(id);
		logger.info(contact.toString());
		return contact;
	}

	

	@GetMapping("/get-contact-ByMobileno")
	public Object getContactByMobileno(@RequestParam Long mobileno)

	{
		@SuppressWarnings("uncheked")
		List<Contact> contact = (List<Contact>) contactService.getContactByMobileno(mobileno);
		logger.info(contact.toString());
		return contact;
	}

	@GetMapping("/get-cotactBy-emailId")
	public Object getContactByemailId(@RequestParam String emailId)
	{
		@SuppressWarnings("unchecked")
		List<Contact>contact=(List<Contact>) contactService.getCotactByEmailId(emailId);
		logger.info(contact.toString());
		return contact;
		
	}
	@GetMapping("/get-contact-byCity")
	public Object getContactByCity(@RequestParam String city) {
		@SuppressWarnings("uncheked")
		List<Contact> contact = (List<Contact>) contactService.getContactByCity(city);
		logger.info(contact.toString());
		return contact;
	}

	@PostMapping("/add-contact")
	public Object addContact(@RequestBody Contact contact) {
		logger.info(contact.toString());
		return contactService.addContact(contact);
	}

	@PutMapping("/update-contact")
	public Object updateContact(@RequestBody Contact contact) {
		logger.info(contact.toString());
		return contactService.updateContact(contact);
	}

	@DeleteMapping("/delete-contact")
	public Object deleteContact(@RequestParam int id) {
		logger.info("Conatct id:" + id);
		return contactService.deleteContact(id);

	}
	@GetMapping("/get-contactByName")
	public Object getContactByName(@RequestParam String name) {
		@SuppressWarnings("unchecked")
		List<Contact>contact=(List<Contact>)contactService.getContactByName(name);
        logger.info(contact.toString());
        return contact;
	}

}
