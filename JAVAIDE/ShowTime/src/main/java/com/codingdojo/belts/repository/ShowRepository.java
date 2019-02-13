package com.codingdojo.belts.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.belts.models.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, Long>
{
	
	List<Show> findAll();
//	List<Show> findAllByOrderByRatingAsc();
	Optional<Show> findById(Long id);

	
}
