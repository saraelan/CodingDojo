package com.codingdojo.dojooverflow.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojooverflow.models.Tag;



@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	Tag findTagBySubject(String search);
}
