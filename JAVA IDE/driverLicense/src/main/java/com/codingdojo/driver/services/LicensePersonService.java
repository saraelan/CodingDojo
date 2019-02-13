package com.codingdojo.driver.services;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.driver.models.License;
import com.codingdojo.driver.models.Person;
import com.codingdojo.driver.repository.LicenseRepository;
import com.codingdojo.driver.repository.PersonRepository;



@Service
public class LicensePersonService {
	private final PersonRepository pRepo;
	private final LicenseRepository lRepo;
	public LicensePersonService(LicenseRepository lRepo, PersonRepository pRepo) {
		this.lRepo = lRepo;
		this.pRepo = pRepo;
	}
	public List<Person> allPeople(){
		return pRepo.findAll();
	}
	public List<License> allLicenses(){
		return lRepo.findAll();
	}
	public Person createPerson(Person p) {
		return pRepo.save(p);
	}
	public Person getPerson(Long id) {
		Optional<Person> p = pRepo.findById(id);
		if(p.isPresent()) {
			return p.get();
		} else {
			return null;
		}
	}
	public License createLicense(License l) {
		return lRepo.save(l);
	}
	
}