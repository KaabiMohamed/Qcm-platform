package com.qcm.platform.repo;

import java.util.List;

import com.qcm.platform.entities.ExamEnCours;
import com.qcm.platform.entities.Question;

public interface QcmService {

	List<Question> generateQuestions(int numberOfQuestions, String Language);

	boolean canCreateQcm(int numberOfQuestions, String Language);

//	ExamEnCours instancierNouvelExam();
//
//	void updateExamEnCoursQuestions();
//
//	boolean verifyTime();
}
