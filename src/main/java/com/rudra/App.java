
package com.rudra;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println("Project Started");


        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();

        //creating student
        Student st =new Student();
        st.setId(102);
        st.setName("Rudra");
        st.setCity("Pune");
        System.out.println(st);

        //Session session =factory.getCurrentSession();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(st);

        tx.commit();

        session.close();


    }
}
