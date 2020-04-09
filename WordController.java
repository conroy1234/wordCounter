package org.wordcount.api.wordCounter;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wordcount.api.wordCounter.exception.ResourceNotFoundException;
import org.wordcount.api.wordCounter.service.WordServiceUtil;
import org.wordcount.api.wordCounter.service.WordService;

@RestController
@RequestMapping
public class WordController {

	@Autowired
	WordService wordService;
	@Autowired
	WordServiceUtil wordServiceUtil;
	@Autowired
	Config config;

	@PostMapping(path = "/input", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Word> addOneWord(@RequestBody Word word) {
		Word save = wordService.save(word);

		if (save == null) {
			throw new ResourceNotFoundException("resource not found =" + word);
		}
		return new ResponseEntity<Word>(save, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/input/{word}/{locale}", method = RequestMethod.GET)
	public String getMessage(@RequestHeader HttpHeaders httpHeaders, @PathVariable String word,
			@PathVariable String locale) {
		
		wordService.findByWord(word);		
		
		List<String> wordsList = wordServiceUtil.numberOfAccurance(word);
		
		Map<String, Long> collect = wordsList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		return config.messageSource().getMessage("'word' :'"+word+"'count:' "+collect.get(word) , null, new Locale(locale));
	}
}
