package techplement_main.copy;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
	private String title;
	private List<Question> questions;
	public Quiz(String title) {
		this.title = title;
		this.questions=new ArrayList<>();
		}
	public void addQuestion(Question question) {
		questions.add(question);
	}
	public void takeQuiz() {
		Scanner scanner = new Scanner(System.in);
		int score =0;
		for(Question question : questions) {
			System.out.println(question.getQuestionText());
			List<String> options = question.getOptions();
			for(int i=0;i<options.size();i++) {
				System.out.println((i+1)+"."+options.get(i));		
			}
			System.out.println("Enter your answer");
			int userAnswer =scanner.nextInt()-1;
			if(question.isCorrect(userAnswer)) {
				score++;
				System.out.println("correct!");
			}
			else {
				System.out.println("wrong! The correct answer is:"+(question.getCorrectAnswerIndex()+1));
			}
			System.out.println();
		}
		System.out.println("you scored"+score+"out of "+questions.size());
	    }
		public String getTitle() {
			return title;
		}
	}
	
	

