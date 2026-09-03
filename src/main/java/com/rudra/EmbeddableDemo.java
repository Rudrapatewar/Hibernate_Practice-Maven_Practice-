package com.rudra;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableDemo {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory factory = configuration.buildSessionFactory();

        //student 1
        Student student1 = new Student();
        //set the student details
        student1.setId(101);
        student1.setName("Sangam");
        student1.setCity("Pune");

        Certificate certificate1 = new Certificate();
        certificate1.setCourse("Pharma Coding");
        certificate1.setDuration("3 months");

        student1.setCerti(certificate1);


        //student 2
        Student student2 = new Student();
        //set the student details
        student2.setId(102);
        student2.setName("Ajinkya");
        student2.setCity("Washim");

        Certificate certificate2 = new Certificate();
        certificate2.setCourse("Android");
        certificate2.setDuration("2 months");

        student2.setCerti(certificate2);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        //save objects
        session.persist(student1);
        session.persist(student2);


        tx.commit();
        session.close();
        factory.close();
    }
}
