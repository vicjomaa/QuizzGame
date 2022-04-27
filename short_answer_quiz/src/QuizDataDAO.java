import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// ArrayList of storage space to store questions
public class QuizDataDAO extends ArrayList<QuestionDTO> {
		
	/**
	* To be able to ask quiz questions
      * Read the quiz data and save it in ArrayList!
      * Data shuffle!
      * @param key 
	 */
	public boolean loadQuiz(int key) {

		//String quizDataPath = "C:\\Quiz" + key + ".dat";
		String quizDataPath = "src\\Quiz" + key + ".dat";
		//System.out.println(quizDataPath);
	
		try {
			Scanner scn = new Scanner(new FileInputStream(quizDataPath));

			while (scn.hasNext()) {
				// Even-numbered questions, odd-numbered answers.
                // Read the question and answer and add it to the Arraylist
				QuestionDTO qDTO = new QuestionDTO(scn.nextLine(), scn.nextLine());
				//System.out.println(qDTO);
				this.add(qDTO);
			}//while------
			
			System.out.println();
			Collections.shuffle(this); // Shuffle the questions(randomly)
			/*
			 * for (Question q: QuizData) { System.out.println(q); }
			 */

		} catch (FileNotFoundException e) {
			System.out.println("Exception : " + e);
			return true;
		}
		
		return false;
	}// loadQuiz()
}
