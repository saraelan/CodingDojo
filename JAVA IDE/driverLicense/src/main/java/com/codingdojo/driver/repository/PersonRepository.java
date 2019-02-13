package com.codingdojo.driver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.driver.models.Person;

public interface PersonRepository extends CrudRepository<Person,Long>{
	List<Person> findAll();
}