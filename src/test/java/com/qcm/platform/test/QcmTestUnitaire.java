package com.qcm.platform.test;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.qcm.platform.entities.Question;
import com.qcm.platform.repo.QcmService;
import com.qcm.platform.repo.QuestionDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class QcmTestUnitaire {

	@Autowired
	QuestionDao questionDao;

	@Autowired
	QcmService qcmService;

	@Test
	public void test() {

		for (int i = 1; i < 4; i++) {

			for (int j = 1; j < 20; j++) {
				Question question = new Question();
				question.setLanguage("java");
				question.setNiveau(i);
				// question.setIdQuestion(i+j);
				question.setQuestion("question" + i + j);
				questionDao.ajouterQuestion(question);
				// System.out.println(question.toString());
			}
		}

		boolean testFalse = qcmService.canCreateQcm(101, "spring");
		Assert.assertEquals(false, testFalse);
	
		boolean testTrue = qcmService.canCreateQcm(30, "java");
		Assert.assertTrue(testTrue);
		
		List<Question> autoGenerate = qcmService.generateQuestions(30, "java");
		for (Question q : autoGenerate) {
			System.out.println(q.toString());
		}

	}

}
