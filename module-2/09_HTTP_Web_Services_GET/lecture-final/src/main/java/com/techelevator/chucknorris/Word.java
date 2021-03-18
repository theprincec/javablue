package com.techelevator.chucknorris;

import org.springframework.web.client.RestTemplate;

public class Word {

	private Meta meta;
	
	
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	
	private final static String END = "https://www.dictionaryapi.com/api/v3/references/thesaurus/json/";
	private final static String KEY = "?key=ca9b93dd-8df7-4fd7-bc5a-866b7b5dac4a";
	private static RestTemplate restTemplate = new RestTemplate();
	
	
	public String getSearchWord(String searchWord) {
		
		String url = END + searchWord + KEY;
		Word word = restTemplate.getForObject(url, Word.class);
		
		String wordId = word.getMeta().getId();
		
		return wordId;
		
	}
	
	
}
