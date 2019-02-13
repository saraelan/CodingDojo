package com.codingdojo.belts.services;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.belts.models.Rating;
import com.codingdojo.belts.models.Show;
import com.codingdojo.belts.repository.RatingRepository;

@Service
public class RatingService {

	private RatingRepository ratingRepo;
	
	public RatingService(RatingRepository ratingRepo)
	{
		this.ratingRepo=ratingRepo;
	}
	
	public Rating create (Rating rating) {
		return ratingRepo.save(rating);
	}
	
	//all ratings
	 public Rating findAll() {
	    	return (Rating) ratingRepo.findAll();
	    }

	 public Rating findOne(Long id) {
			Optional<Rating> rating = ratingRepo.findById(id);
			if (rating.isPresent()) {
				return rating.get();
			} else {
				return null;
			}
		}

	public List<Rating> findByShow(Show cur) {
		return ratingRepo.findByShow(cur);
	}
	 
	 
	 
}
