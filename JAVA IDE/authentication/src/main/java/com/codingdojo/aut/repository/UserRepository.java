package com.codingdojo.aut.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.aut.model.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	 User findByEmail(String email);

}
