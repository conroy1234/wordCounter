package org.wordcount.api.wordCounter;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.wordcount.api.wordCounter.service.WordService;
import org.wordcount.api.wordCounter.service.WordServiceUtil;

@SpringBootApplication

public class WordCounterApplication implements CommandLineRunner{
	@Autowired
	WordService wordService;
	
	@Autowired
	WordServiceUtil wordServiceUtil;
	
	public static void main(String[] args) {
		SpringApplication.run(WordCounterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String data = wordServiceUtil.numberOfAccuranceString("monday", "test", "tom", "tom", "tom", "conroy","conroy");
		
		Word word= new Word(data);
		wordService.save(word);
		
	}



	
}
