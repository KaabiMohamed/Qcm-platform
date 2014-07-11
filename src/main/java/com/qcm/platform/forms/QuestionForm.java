package com.qcm.platform.forms;

import javax.persistence.ManyToOne;

import com.qcm.platform.entities.Question;

public class QuestionForm {

	/**
	 * 
	 */

	public QuestionForm() {

	}

	private int id;
	private int currentQuestionNumber;
	private String check0;
	private String check1;
	private String check2;
	private String check3;
	private int nextQuestionNumber;
	private long remainingTime;
	@ManyToOne
	private Question question;

	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

	/**
	 * @return the remainingTime
	 */
	public long getRemainingTime() {
		return remainingTime;
	}

	/**
	 * @param remainingTime
	 *            the remainingTime to set
	 */
	public void setRemainingTime(long remainingTime) {
		this.remainingTime = remainingTime;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the currentQuestionNumber
	 */
	public int getCurrentQuestionNumber() {
		return currentQuestionNumber;
	}

	/**
	 * @param currentQuestionNumber
	 *            the currentQuestionNumber to set
	 */
	public void setCurrentQuestionNumber(int currentQuestionNumber) {
		this.currentQuestionNumber = currentQuestionNumber;
	}

	/**
	 * @return the check0
	 */
	public String getCheck0() {
		return check0;
	}

	/**
	 * @param check0
	 *            the check0 to set
	 */
	public void setCheck0(String check0) {
		this.check0 = check0;
	}

	/**
	 * @return the check1
	 */
	public String getCheck1() {
		return check1;
	}

	/**
	 * @param check1
	 *            the check1 to set
	 */
	public void setCheck1(String check1) {
		this.check1 = check1;
	}

	/**
	 * @return the check2
	 */
	public String getCheck2() {
		return check2;
	}

	/**
	 * @param check2
	 *            the check2 to set
	 */
	public void setCheck2(String check2) {
		this.check2 = check2;
	}

	/**
	 * @return the check3
	 */
	public String getCheck3() {
		return check3;
	}

	/**
	 * @param check3
	 *            the check3 to set
	 */
	public void setCheck3(String check3) {
		this.check3 = check3;
	}

	/**
	 * @return the nextQuestionNumber
	 */
	public int getNextQuestionNumber() {
		return nextQuestionNumber;
	}

	/**
	 * @param nextQuestionNumber
	 *            the nextQuestionNumber to set
	 */
	public void setNextQuestionNumber(int nextQuestionNumber) {
		this.nextQuestionNumber = nextQuestionNumber;
	}

}
