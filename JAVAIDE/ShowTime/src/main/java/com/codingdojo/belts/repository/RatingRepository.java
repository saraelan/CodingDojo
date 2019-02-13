package com.codingdojo.belts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.belts.models.Rating;
import com.codingdojo.belts.models.Show;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
	List<Rating> findAll();
	List<Rating> findByShow(Show show);
}
