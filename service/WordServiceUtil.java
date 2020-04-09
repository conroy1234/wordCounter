package org.wordcount.api.wordCounter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wordcount.api.wordCounter.model.WordRepository;


@Component
public class WordServiceUtil {

	@Autowired
	WordRepository wordRepository;

	Logger logger = LoggerFactory.getLogger(WordServiceUtil.class);

	private List<String> wordsList = new ArrayList<>();

	private static final String REGEX = "^[a-zA-Z0-9]*$";

	/*
	 * add word to collection
	 */
	public List<String> addWord(String... words) {
		for (String word : words) {
			if (ensureWordIseAlphapetical(word)) {
				this.wordsList.add(word);
			}

		}
		return wordsList;
	}

	/*
	 * number of occurrence with collection
	 */
	public List<String> numberOfAccurance(String... words) {
		this.wordsList = addWord(words);		
		return wordsList;
	}

	/*
	 * optional string implementation of number of accurance
	 */
	public String numberOfAccuranceString(String... words) {
		this.wordsList = addWord(words);		
		return wordsList.toString();
	}

	/*
	 * ensure that only alphabetical will be accepter
	 */
	private boolean ensureWordIseAlphapetical(String word) {
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(word);
		if (!matcher.matches()) {
			wordsList.remove(word);
			logger.info(word + " has been removed because it is not alphabetical");
		}
		return matcher.matches();

	}

}
