package org.wordcount.api.wordCounter.model;

import javax.persistence.NamedQuery;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wordcount.api.wordCounter.Word;

@Repository
@NamedQuery(name = "findByWord", query = "from word where word = :word")
public interface WordRepository extends CrudRepository<Word, Integer> {
	
	Word findByWord(String word);

}
