package OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;
import java.util.List;

public class OneToManyMapDemo {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory factory = configuration.buildSessionFactory();

        //create the question
        Question1 question1 = new Question1();
        question1.setQuestionId(101);
        question1.setQuestion("What is java");

        //create the answer
        Answer1 answer1 = new Answer1();
        answer1.setAnswerId(1);
        answer1.setAnswer("Java is Programming Language");
        answer1.setQuestion1(question1);

        //create the answer
        Answer1 answer2 = new Answer1();
        answer2.setAnswer("java is used for developing software");
        answer2.setAnswerId(2);
        answer2.setQuestion1(question1);

        //session
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        List<Answer1> list = new ArrayList<>();
        list.add(answer1);
        list.add(answer2);

        question1.setAnswer1(list);
        //save
        session.persist(question1);
        session.persist(answer1);
        session.persist(answer2);

/*      //for fetching data
        Question1 q =(Question1)session.find(Question1.class,101);

        System.out.println(q.getQuestion());

        for (Answer1 a : q.getAnswer1()){
            System.out.println(a.getAnswer());
        }
*/
        tx.commit();
        session.close();
        factory.close();
    }
}
