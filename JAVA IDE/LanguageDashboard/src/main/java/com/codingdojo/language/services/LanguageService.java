package com.codingdojo.language.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.language.models.Language;
import com.codingdojo.language.repositories.LanguageRepository;


@Service
public class LanguageService {

	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository)
	{
		this.languageRepository=languageRepository;
		
	}
	
	 public List<Language> allLanguages() {
	        return languageRepository.findAll();
	 }
	 
	public Language createLanguage(Language l) {
	            return languageRepository.save(l);
	        }
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) 
		{
            return optionalLanguage.get();
        } 
		
		else 
		{
            return null;
        }
    }
	
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}
	
	public Language updateLanguage(Long id, String name, String creator, String version) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) 
		{
			Language language =optionalLanguage.get();
			language.setName(name);
			language.setCreator(creator);
			language.setVersion(version);
			
			return languageRepository.save(language);
	    
			
		}
		else
		{
			return null;
		}
		
		
	}
	
}
