package techplement_main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuizGenerator {
	private static List<Quiz> quizzes = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		hardCodeQuizzes();
		while(true) {
			System.out.println("1.Take Quiz");
			System.out.println("2.Create Quiz");
			System.out.println("3.Add questions to Quiz");
			System.out.println("4.Exit");
			System.out.println("Choose an Option(1,2,3,4):");
			int option = sc.nextInt();
			switch(option) {
			case 1:
				takeQuiz();
				break;
			case 2:
				createQuiz();
				break;
			case 3:
				addQuestionToQuiz();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Invalid choice,please try again.");
			}
		}
	}
	
	private static void createQuiz() {
		
		System.out.println("Enter the quiz title: ");
		sc.nextLine();
		String title = sc.nextLine();
		quizzes.add(new Quiz(title));
		System.out.println("Quiz created successfully");
	}
	private static void addQuestionToQuiz() {
		System.out.println("Available quiz topics are :");
		for(Quiz quiz: quizzes) {
			System.out.print(quiz.getTitle()+"  ");
		}
		System.out.println();
		System.out.println("enter the title(one of the above mention topics) :");
		sc.nextLine();
		String title = sc.nextLine();
		Quiz quiz = findQuizByTitle(title);
		if(quiz == null) {
			System.out.println("Quiz not found");
			return;
		}
		System.out.println("Enter the Question text:");
		String questionText=sc.nextLine();
		List<String> options = new ArrayList<>();
		for(int i=1;i<=4;i++) {
			System.out.println(" Enter option "+ i +":");
			options.add(sc.nextLine());
		}
		System.out.println("Enter the number of the correct answer(1-4):");
		int correctAnswerIndex=sc.nextInt()-1;
		sc.nextLine();
		quiz.addQuestion(new Question(questionText,options,correctAnswerIndex));
		System.out.println("Question added successful!");
	}
	private static void takeQuiz() {
		System.out.println("Available Quizz topics are :");
		for(Quiz quiz: quizzes) {
			System.out.println(quiz.getTitle());
		}
		System.out.println("Enter the quiz title(above title name): ");
		sc.nextLine();
		String title = sc.nextLine();
		Quiz quiz = findQuizByTitle(title);
		if(quiz == null) {
			System.out.println("Quiz not found");
			return;
		}
		quiz.takeQuiz();
		
	}
	private static Quiz findQuizByTitle(String title) {
		for(Quiz quiz: quizzes) {
			if(quiz.getTitle().equalsIgnoreCase(title)) {
				return quiz;
			}
		}
		return null;
	}
	private static void hardCodeQuizzes() {
		quizzes.add(new Quiz("GK"));
		quizzes.add(new Quiz("Java"));
		quizzes.add(new Quiz("Maths"));
		
		Quiz quiz1 = findQuizByTitle("Gk");
		quiz1.addQuestion(new Question("Who is first prime minister of India ?",List.of("Rajeev Gandhi","Indira Gandhi","Jawaharal Nehru","Narendra Modi"),2));
		quiz1.addQuestion(new Question("In which year \"India\" got independence ?", List.of("1947","1948","1952","1940"), 0));
		quiz1.addQuestion(new Question("Who is present Home Minister of India ?", List.of("Yogi Adityanath","Amit Shah","Rajnath Singh","Rahul Gandhi"), 1));
		
		Quiz quiz2 = findQuizByTitle("Java");
		quiz2.addQuestion(new Question("Which operator is used for addition in java?", List.of("\"-\"","\"/\"","\"*\"","\"+\""),3 ));
		quiz2.addQuestion(new Question("select the valid statement", List.of("char[] ch = new char(5);","char[] ch = new char[5];","char[] ch = new char();","char[] ch = new char[];"), 1) );
		quiz2.addQuestion(new Question("In which of the following is toString() methhod ?", List.of("java.lang.Object","java.lang.String","java.lang.Scanner","None of the above"), 0));
		
		Quiz quiz3 = findQuizByTitle("Maths");
		quiz3.addQuestion(new Question("πr² is the formula for", List.of("The area of a circle","The area of a cube","The area of a triangle","None of the above"), 0));
		quiz3.addQuestion(new Question("152/4 ", List.of("39","38","42","44"), 1));
		quiz3.addQuestion(new Question("What is prime number?", List.of("A number with morethan 2 factors","A Whole number","A number with only factors 1 and itself","None of the above"), 2));
	}
}
