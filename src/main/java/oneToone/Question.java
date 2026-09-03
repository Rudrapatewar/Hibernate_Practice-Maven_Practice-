package oneToone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Question {

    @Id
    @Column(name = "question_id")
    private int questionId;
    private String question;
    @OneToOne
    private Answer answer;



    public Question() {

    }

    public Question(int question_id, String question) {
        this.questionId = question_id;
        this.question = question;
    }

    public int getQuestion_id() {
        return questionId;
    }

    public void setQuestion_id(int question_id) {
        this.questionId = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
