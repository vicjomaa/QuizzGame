import java.util.InputMismatchException;
import java.util.Scanner;

public class Play {
	
	private int result = 0;	//store the right answer
	private String menuString; //category of menu
	private int qTotalOuput; //number of questions
	private QuizDataDAO quizData; //ArrayList for store the questions
	
	//Constructor
	public Play() {
		this(5); //default number of questions is 5
	}	
	public Play(int size) {
		quizData = new QuizDataDAO();			
		qTotalOuput = size;
	}	
	

	/** SHOW THE MENU **/
	public void showMenu(){
		Scanner scn = new Scanner(System.in);
		String[] menuStringList =new String[]{"Software Engineering","Machine Learning","Deep Learning","AI"};
		while (true) {
			System.out.println();
			System.out.println("===== Mini Quiz Start====");
			System.out.println("1) Software Engineering  2) Machine Learning");
			System.out.println("3) Deep Learning         4) AI              ");
			System.out.println("5) FINISH ");
			System.out.print("===Please Select the Category===\n:");
			
			try {
				int key = scn.nextInt();	//input the menu(category)			
				switch (key) {
				case 1:	case 2:	case 3:	case 4:
					
					System.out.println(key + "category has been selected.");
					menuString = menuStringList[key-1];
					if(quizData.loadQuiz(key)) continue;  
					// Load the quiz file of the relevant item and save it in the Arraylist
                    // If there is no file, return to the menu screen without executing the following statement.
					
					startQuiz(); //Quiz Start
					System.out.println("Press Any Key to View the Menu!");
					scn.nextLine();
					scn.nextLine();
					break;
					
				case 5:
					System.out.println("Finish This Game");
					System.exit(0);
					break;
					
				default:			
					throw new InputMismatchException();					
				}// switch
			} catch (InputMismatchException e) {
				System.out.println("Input Error!");
				scn.nextLine();
			}
		}// while
		
	}//showMenu()----------
	
	
	/**QUIZ START**/
	private void startQuiz() {
		System.out.println("#START THIS GAME!");
		Scanner scn = new Scanner(System.in);
		if(qTotalOuput>quizData.size()) qTotalOuput = quizData.size();
		for (int i = 0; i < qTotalOuput; i++) {
			QuestionDTO qDTO = quizData.get(i);
			String question = qDTO.getQuestion();
			String answer = qDTO.getAnswer();

			System.out.println((i + 1) + ") " + question);
			String user_Answer = scn.nextLine();

			if (answer.equals(user_Answer)) {
				System.out.println("#Congrats!");
				result++;
			} else {
				System.out.println("#Sorry...");
			}
			System.out.println();
		}//for()------
		System.out.println("#Completed All");
		quizData.clear(); //initialize the quiz
		showResult(); ////print the result
	
	}//startQuiz()---------
	
	/**THE RESULT**/
	public void showResult(){
		
		System.out.println("===== Mini Quiz Result====");
		System.out.println("Category : "+menuString);
		System.out.println("Questions : "+qTotalOuput);
		System.out.println("Correct Answers : "+result);
		System.out.printf("Score : %.1f\n",result*(100.0/qTotalOuput));
		System.out.println("==========================");
	}//showResult()---------
}
