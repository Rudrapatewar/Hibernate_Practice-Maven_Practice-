package OneToMany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Question1 {

    @Id
    @Column(name = "question_id")
    private int questionId;

    private String question;

    @OneToMany(mappedBy = "question1")
    private List<Answer1> answer1;

    public Question1() {
    }

    public Question1(int questionId, String question, List<Answer1> answer1) {
        this.questionId = questionId;
        this.question = question;
        this.answer1 = answer1;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer1> getAnswer1() {
        return answer1;
    }

    public void setAnswer1(List<Answer1> answer1) {
        this.answer1 = answer1;
    }
}
