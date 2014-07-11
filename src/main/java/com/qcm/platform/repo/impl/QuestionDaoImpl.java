package com.qcm.platform.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qcm.platform.entities.Question;
import com.qcm.platform.repo.QuestionDao;

@Repository
@Transactional
public class QuestionDaoImpl implements QuestionDao {

	@Autowired
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public QuestionDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int ajouterQuestion(Question question) {

		entityManager.persist(question);

		return question.getIdQuestion();

	}

	@Override
	public void modifierQuestion(Question question) {
		entityManager.merge(question);

	}

	@Override
	public void supprimerQuestion(Question question) {
		Question managed = entityManager.merge(question);
		entityManager.remove(managed);

	}

	@Override
	public Question recherchQuestion(int id) {

		return entityManager.find(Question.class, id);
	}

	@Override
	public List<Question> questions() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select a from Question a")
				.getResultList();
	}

	@Override
	public List<String> getLanguages() {
		// TODO Auto-generated method stub
		return entityManager.createQuery(
				"select a.language from Question a group by a.language")
				.getResultList();
	}

	@Override
	public List<Question> filterByLangauge(String language,int PageNumber) {
		
		TypedQuery<Question> query = this.entityManager.createQuery(
				"select a from Question a where a.language='" + language + "'", Question.class);

		int firstResult = (PageNumber-1)*10;
		
		return query.setFirstResult(firstResult).setMaxResults(10)
				.getResultList();
		
		
	}

	@Override
	public List<Question> questionsPager(int PageNumber) {
		TypedQuery<Question> query = this.entityManager.createQuery(
				"select m from Question m", Question.class);

		int firstResult = (PageNumber-1)*10 ;
		
		return query.setFirstResult(firstResult).setMaxResults(10)
				.getResultList();
	}

	@Override
	public int numberOfPages() {
		TypedQuery<Long> query = this.entityManager.createQuery("select count(m) from Question m", Long.class);
		Long numberOfQuestions = query.getSingleResult();
		int numberOfPages = 0;
		
		if(numberOfQuestions%10!=0){
			numberOfPages = (int) ((numberOfQuestions/10)+1);
		}
		else{
			numberOfPages = (int) ((numberOfQuestions/10));
		}
	
		return numberOfPages;
	}

}
