package techplement_main.copy;

import java.util.List;

public class Question {
	private String questionText;
	private List<String> options;
	private int correctAnswerIndex;
	public Question(String questionText, List<String> options, int correctAnswerIndex) {
		this.questionText = questionText;
		this.options = options;
		this.correctAnswerIndex = correctAnswerIndex;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	
	public String getQuestionText() {
		return questionText;
	}
	public List<String> getOptions() {
		return options;
	}
	public int getCorrectAnswerIndex() {
		return correctAnswerIndex;
	}
	public boolean isCorrect(int userAnswerIndex) {
		return userAnswerIndex==correctAnswerIndex;
	}
	
}
