package org.wordcount.api.wordCounter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wordcount.api.wordCounter.Word;
import org.wordcount.api.wordCounter.model.WordRepository;

@Service
public class WordService {
	
@Autowired
WordRepository wordRepository;

@Autowired
WordServiceUtil wordServiceUtil;

	public Word save(Word entity){		
		entity=wordRepository.save(entity);
		return entity;
	}
	
	public Word findByWord(String word) {
		return wordRepository.findByWord(word);
	}
	
	
}
