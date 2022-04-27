
// A class definition that stores one question
public class QuestionDTO {
	private String question;
	private String answer;


	public QuestionDTO() {
	
	}
	
	public QuestionDTO(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}


	public String getQuestion() {
		return question;
	}
	public String getAnswer() {
		return answer;
	}
	
	@Override
	public String toString() {
		return "Question [question=" + question + ", answer=" + answer + "]";
	}
	
	
}
