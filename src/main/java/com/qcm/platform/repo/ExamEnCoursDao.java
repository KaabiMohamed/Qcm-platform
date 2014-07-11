package com.qcm.platform.repo;

import com.qcm.platform.entities.ExamEnCours;

public interface ExamEnCoursDao {

	void ajouterExamEnCours(ExamEnCours examEnCours);

	void modifierExamEnCours(ExamEnCours examEnCours);

	void supprimerExamEnCours(ExamEnCours examEnCours);
	
	ExamEnCours findExamEnCoursForQcmAndUser(String idQcm,String isUser );
	
	ExamEnCours findExamEnCoursForId(int id);

}
