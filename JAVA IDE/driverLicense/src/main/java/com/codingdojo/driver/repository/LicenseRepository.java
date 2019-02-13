package com.codingdojo.driver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.driver.models.License;

public interface LicenseRepository extends CrudRepository<License, Long> {
	List<License> findAll();

}