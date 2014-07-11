package com.qcm.platform.repo;

import java.util.List;

import com.qcm.platform.entities.Question;

public interface QuestionDao {

	public int ajouterQuestion(Question question);

	public void modifierQuestion(Question question);

	public void supprimerQuestion(Question question);

	public Question recherchQuestion(int id);

	public List<Question> questions();
	
	public List<String> getLanguages();
	
	public List<Question> filterByLangauge(String language,int pageNumber);
	
	public List<Question> questionsPager(int pageNumber);
	
	public int numberOfPages();

}
