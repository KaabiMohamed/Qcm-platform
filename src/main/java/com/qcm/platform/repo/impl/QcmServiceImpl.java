package com.qcm.platform.repo.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qcm.platform.entities.Question;
import com.qcm.platform.repo.QcmService;

@Repository
@Transactional
public class QcmServiceImpl implements QcmService {

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Question> generateQuestions(int numberOfQuestions,
			String Language) {
		List<Question> listeDeQuestion = new ArrayList<Question>();
		int questionsParNiveau = numberOfQuestions / 3;
		int reste = numberOfQuestions % 3;

		// Generation de questions du Level 1
		List<Question> level1 = this.entityManager
				.createQuery(
						"select a from Question a where a.language='"
								+ Language
								+ "' And a.niveau=1 ORDER BY RAND()",
						Question.class).setMaxResults(questionsParNiveau)
				.getResultList();
		listeDeQuestion.addAll(level1);
		// Generation de questions du level 2
		List<Question> level2 = this.entityManager
				.createQuery(
						"select a from Question a where a.language='"
								+ Language
								+ "' AND a.niveau=2 ORDER BY RAND()",
						Question.class).setMaxResults(questionsParNiveau)
				.getResultList();
		listeDeQuestion.addAll(level2);
		// Generation de questions du level 3 (les questions supplementaire du
		// mod sont ajoutees au niveau expert)
		List<Question> level3 = this.entityManager
				.createQuery(
						"select a from Question a where a.language='"
								+ Language
								+ "' AND a.niveau=3 ORDER BY RAND()",
						Question.class).setMaxResults(questionsParNiveau+reste)
				.getResultList();
		listeDeQuestion.addAll(level3);

		return listeDeQuestion;
	}

	@Override
	public boolean canCreateQcm(int numberOfQuestions, String Language) {
		
		List<Question> list = generateQuestions(numberOfQuestions, Language);
		if(list.size()==numberOfQuestions){
			return true;
		}
		return false;
	}

}
