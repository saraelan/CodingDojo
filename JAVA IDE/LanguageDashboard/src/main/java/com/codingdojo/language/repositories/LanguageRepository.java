package com.codingdojo.language.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.language.models.Language;

public interface LanguageRepository extends CrudRepository<Language,Long>

{
List<Language> findAll();
List<Language> findByCreatorContaining(String search);

}
