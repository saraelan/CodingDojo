package com.codingdojo.dojooverflow.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repository.TagRepository;


@Service
public class TagService {
	
	private TagRepository tagRepository;
	
	public Tag findTagById(Long id) {
		return tagRepository.findOne(id);
	}
	
	public void addTag(Tag tag) {
		tagRepository.save(tag);
	}
	
	public List<Tag> getTags() {
		return (List<Tag>) tagRepository.findAll();
	}

}
