package com.kcsitglobal.contact.reopository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kcsitglobal.contact.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	List<Contact>findByName(String name);
	List<Contact>findByCity(String city);
	//List<Contact>findByMobileno(int mobileno);
	List<Contact> findByMobileno(Long mobileno);
	List<Contact> findByEmailId(String emailId);

}
