package oneToone;

import OneToMany.Answer1;
import OneToMany.Question1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneTOOneMapDemo {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory factory = configuration.buildSessionFactory();

        //creating question
        Question question1 = new Question();
        question1.setQuestion_id(1);
        question1.setQuestion("What is Collection Framework");
        //creating answer
        Answer answer1 = new Answer();
        answer1.setAnswer_id(2);
        answer1.setAnswer("Api to work with objects in java");
        answer1.setQuestion(question1);

        question1.setAnswer(answer1);


        //creating question
        Question question2 = new Question();
        question2.setQuestion_id(11);
        question2.setQuestion("What is java");
        //creating answer
        Answer answer2 = new Answer();
        answer2.setAnswer_id(22);
        answer2.setAnswer("Java is Programming Language");
        answer2.setQuestion(question2);

        question2.setAnswer(answer2);

        // session
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        //save
        session.persist(answer1);
        session.persist(answer2);

        session.persist(question1);
        session.persist(question2);


        tx.commit();
        session.close();
        factory.close();
    }
}
