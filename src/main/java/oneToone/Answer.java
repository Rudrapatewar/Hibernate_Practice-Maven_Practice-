package oneToone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Answer {

    @Id
    @Column(name = "answer_id")
    private int answerId;
    private String answer;

    @OneToOne(mappedBy = "answer") // it will not create the question_id column in answer table
    private Question question; // it will become bidirectional

    public Answer() {
    }

    public Answer(int answer_id, String answer) {
        this.answerId = answer_id;
        this.answer = answer;
    }

    public int getAnswer_id() {
        return answerId;
    }

    public void setAnswer_id(int answer_id) {
        this.answerId = answer_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
