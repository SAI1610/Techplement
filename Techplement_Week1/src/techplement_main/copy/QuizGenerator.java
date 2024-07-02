package techplement_main.copy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizGenerator {
	static String[] generalKnowledge = new String[] {"C","A","B"};
	static String[] coreJava=new String[] {"D","B","A"};
	static String[] maths = new String[]{"A","B","C"};
	static String[] answer = new String[] {"0","0","0","0","0"};
	private static List<Quiz> quizzes = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		while(true) {
			System.out.println("1.Take Quiz");
			System.out.println("2.Create Quiz");
			System.out.println("3.Add questions to Quiz");
			System.out.println("4.Exit");
			System.out.println("Choose an Option(1,2,3,4):");
			int option = sc.nextInt();
			switch(option) {
			case 1:
				System.out.println("Available Quiz topics are");
				System.out.println("1.General knowldege");
				System.out.println("2.Core java");
				System.out.println("3.Mathematical");
				System.out.println("Enter Quiz Topic Number to take Test: ");
				int topicNumber = sc.nextInt();
				switch(topicNumber) {
				case 1:
					System.out.println("1.Who is first prime minister of India ?");
					System.out.println("A.Rajeev Gandhi");
					System.out.println("B.Indira Gandhi");
					System.out.println("C.Jawaharal Nehru");
					System.out.println("D.Narendra Modi");
					System.out.println("Choose answer(A,B,C,D) : ");
					
					answer[0]= sc.next();
					
					System.out.println("2.In which year \"India\" got independence");
					System.out.println("A.1947");
					System.out.println("B.1948");
					System.out.println("C.1957");
					System.out.println("D.1940");
					System.out.println("Choose answer(A,B,C,D) : ");
					
					answer[1] = sc.next();
					
					System.out.println("3.Who is presenet Home Minister of India ?");
					System.out.println("A.Yogi Adityanath");
					System.out.println("B.Amit Shah");
					System.out.println("C.Rajnath singh");
					System.out.println("D.Rahul Gandhi");
					System.out.println("Choose answer(A,B,C,D) : ");
					
					answer[2] = sc.next();
					result(generalKnowledge);
					break;
				case 2:
					System.out.println("1.Which opeartor is used for addition in java?");
					System.out.println("A.\"-\"");
					System.out.println("B.\"/\"");
					System.out.println("C.\"*\"");
					System.out.println("D.\"+\"");
					System.out.println("Choose answer(A,B,C,D) : ");
					
					answer[0]= sc.next();
					
					System.out.println("2.select the valid statement");
					System.out.println("A.char[] ch = new char(5);");
					System.out.println("B.char[] ch = new char[5];");
					System.out.println("C.char[] ch = new char();");
					System.out.println("D.char[] ch = new char[];");
					System.out.println("Choose answer(A,B,C,D) : ");
					
					answer[1] = sc.next();
					
					System.out.println("3.In which of the following is toString() methhod ?");
					System.out.println("A.java.lang.Object");
					System.out.println("B.java.lang.String");
					System.out.println("C.java.lang.Scanner");
					System.out.println("D.None");
					System.out.println("Choose answer(A,B,C,D) : ");
					
					answer[2] = sc.next();
					result(coreJava);
					break;
				case 3:
					System.out.println("1.πr² is the formula for");
					System.out.println("A.The area of a circle");
					System.out.println("B.The area of a cube");
					System.out.println("C.The area of a triangle");
					System.out.println("D.None of the above");
					System.out.println("Choose answer(A,B,C,D) : ");
					
					answer[0]= sc.next();
					
					System.out.println("2.152/4 ");
					System.out.println("A.39");
					System.out.println("B.38");
					System.out.println("C.42");
					System.out.println("D.44");
					System.out.println("Choose answer(A,B,C,D) : ");
					
					answer[1] = sc.next();
					
					System.out.println("3.What is prime number?");
					System.out.println("A. A number with morethan 2 factors");
					System.out.println("B.A Whole number");
					System.out.println("C.A number with only factors 1 and itself");
					System.out.println("D.None of the above");
					System.out.println("Choose answer(A,B,C,D) : ");
					
					answer[2] = sc.next();
					result(maths);
					break;
								
				}
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
	static void result(String[] topic) {
		int count =0;
		for(int i =0; i<topic.length;i++) { 
			if((topic[i]).equalsIgnoreCase((answer[i]))){
				 count++; 
			} 
		 }
		 System.out.println("you scored"+count+"/"+topic.length);
		 if(count==0)
			 System.out.println("you failed..do  more pratices to get good marks ");
		 else if(count==1)
			 System.out.println("Not Bad do more pratice to get good morks");
			  
		 else 
			 System.out.println("Excellent");
			 
		}
	private static void createQuiz() {
		System.out.println("enter the quiz title: ");
		String title = sc.nextLine();
		quizzes.add(new Quiz(title));
		System.out.println("Quiz created successfully");
	}
	private static void addQuestionToQuiz() {
		System.out.println("Enter the quiz title:");
		String title = sc.nextLine();
		Quiz quiz = findQuizByTitle(title);
		if(quiz == null) {
			System.out.println("Quiz not found");
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
		sc.nextInt();
		quiz.addQuestion(new Question(questionText,options,correctAnswerIndex));
		System.out.println("Question added successful!");
	}
	private static void takeQuiz() {
		System.out.println("Enter the quiz title: ");
		String title = sc.nextLine();
		Quiz quiz = findQuizByTitle(title);
		if(quiz == null) {
			System.out.println("Quiz not found");
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
}
