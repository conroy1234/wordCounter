package org.wordcount.api.wordCounter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Word {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String word;
	@Transient
	private Long numberOfAccurance;
	
	public Word(String word, Long numberOfAccurance) {		
		this.word = word;
		this.numberOfAccurance = numberOfAccurance;
	}
	public Word(String word) {
		this.word = word;
	}
	
	public Word() {
		
	}
	public Long getNumberOfAccurance() {
		return numberOfAccurance;
	}
	public void setNumberOfAccurance(Long long1) {
		this.numberOfAccurance = long1;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	@Override
	public String toString() {
		return "Word [id=" + id + ", word=" + word + ", numberOfAccurance=" + numberOfAccurance + "]";
	}
	
	
	
	
}
