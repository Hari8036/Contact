package com.kcsitglobal.contact.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.kcsitglobal.contact.model.Contact;
import com.kcsitglobal.contact.reopository.ContactRepository;

@Service
public class ContactService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ContactRepository contactRepository;

	public Object getContacts() {
		return contactRepository.findAll();
	}

	public Object getContactById(int id) {
		return contactRepository.findById(id);

	}

	

	public Object addContact(Contact contact) {
		logger.info(contact.toString());
		contactRepository.save(contact);
		logger.info("Contact Addded Sucessfully");
		return new ResponseEntity<>("Contact Added Sucessfully", HttpStatus.CREATED);
	}

	public Object updateContact(Contact contact) {
		JsonObject response = new JsonObject();
		System.out.println("Request Contact:" + contact);
		int id = contact.getId();
		try {
			Contact con = contactRepository.getOne(id);
			System.out.println("Request Contact:" + con);
			System.out.println("Old Contact:" + con);
			con.setCity(contact.getCity());
			con.setEmailId(con.getEmailId());
			System.out.println("New Contact:" + con);
			contactRepository.save(con);

		} catch (Exception e) {
			logger.info(e.getMessage());
			response.addProperty("statusCode", 404);
			response.addProperty("statusCode", e.getMessage());
			return new ResponseEntity<>(response.toString(), HttpStatus.NOT_FOUND);

		}
		logger.info("Contact Updated Sucessfully");
		return new ResponseEntity<>("Contact Updated Sucessfully", HttpStatus.OK);
	}

	public Object deleteContact(int id) {
		try {
			contactRepository.deleteById(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		logger.info("Contact Deleted Sucesfully");
		return new ResponseEntity<>("Contact Deleted sucessfully", HttpStatus.OK);

	}

	public List<Contact> getContactByCity(String city) {
		return contactRepository.findByCity(city);
	}

	public List<Contact> getContactByMobileno(Long mobileno) {
		return contactRepository.findByMobileno(mobileno);
	}

	public List<Contact> getCotactByEmailId(String emailId) {

		return contactRepository.findByEmailId(emailId);
	}

	public List<Contact> getContactByName(String name) {
		
		return contactRepository.findByName(name);
	}

}
