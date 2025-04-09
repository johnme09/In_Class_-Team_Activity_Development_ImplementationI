import java.util.Arrays;
import java.util.LinkedList;

public class Question extends Content{
    private int answerCount;
    private LinkedList<String> answers;
    private int correctAnswer;
    private double points;

    private Question(double points, int correctAnswer, LinkedList<String> answers, String prompt){
	super(prompt);
        this.points = points;
        this.correctAnswer = correctAnswer;
        this.setAnswers(answers);
    }

    public boolean equals(Content other){
        if(!(other instanceof Question))
            return false;
        Question otherQuestion = (Question) other;

        if(!this.answers.equals(otherQuestion.getAnswers()))
            return false;

        return true;
    }

    public static Question createMCQuestion(double points, int correctAnswer, LinkedList<String> answers, String prompt){
        return new Question(points, correctAnswer, answers, prompt);
    }

    public static Question createMCQuestion(double points, String correctAnswer, LinkedList<String> answers, String prompt){
        return new Question(points, answers.indexOf(correctAnswer), answers, prompt);
    }

    public static Question createTFQuestion(double points, int correctAnswer, String prompt){
        LinkedList<String> answers = new LinkedList<String>(Arrays.asList("True", "False"));
        return new Question(points, correctAnswer, answers, prompt);
    }

    public static Question createTFQuestion(double points, boolean correctAnswer, String prompt){
        return createTFQuestion(points, correctAnswer?0:1, prompt);
    }

    public double getPoints(){
        return this.points;
    }

    public LinkedList<String> getAnswers(){
        return this.answers;
    }

    public int getAnswerCount(){
        return answerCount;
    }

    public void setPoints(double points){
        this.points = points;
    }

    public void setAnswers(LinkedList<String> answers){
        this.answers = answers;
        this.answerCount = answers.size();
    }

    public boolean isCorrect(String answer){
        return answer == answers.get(correctAnswer);
    }
}
