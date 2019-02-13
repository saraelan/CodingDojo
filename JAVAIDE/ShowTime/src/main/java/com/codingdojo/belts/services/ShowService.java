package com.codingdojo.belts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.belts.models.Show;
import com.codingdojo.belts.repository.ShowRepository;

@Service
public class ShowService {
	
private ShowRepository showrepo;

public ShowService(ShowRepository showrepo)
{
	this.showrepo=showrepo;
}

//create shows
public Show create(Show show)
{
return showrepo.save(show);
	
}

//update show
public Show update(Show show)
{
	return showrepo.save(show);
}

//List all shows
public List<Show> allShows()
{
	return (List<Show>) showrepo.findAll();
}

//Find one 
public Show findOne(Long id) {
	Optional<Show> show = showrepo.findById(id);
	if (show.isPresent()) {
		return show.get();
	} else {
		return null;
	}
}

//delete show
public void deleteShow(Long id) {
showrepo.deleteById(id);
}

}
