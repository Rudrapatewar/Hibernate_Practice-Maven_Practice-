package com.rudra;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println("Project Started");


        Configuration cfg = new Configuration();
        cfg.configure(); // if not able to find file then give the file name here
        SessionFactory factory = cfg.buildSessionFactory();

        //creating student
        Student st =new Student();
        st.setId(105);
        st.setName("Rahul");
        st.setCity("Nanded");
        System.out.println(st);

        //creating object of address class
        Address ad =new Address();
        ad.setStreet("street 1");
        ad.setCity("DELHI");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.25);

        //reading the image file
        FileInputStream file = new FileInputStream("src/main/resources/Defender.jpeg");
        byte[] data = new byte[file.available()];
        file.read(data);
        ad.setImage(data);

        //Session session =factory.getCurrentSession();  Commented this because we did'n have
                                                    // any session we have to open new session
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction(); // we use transaction when we have to save data

        session.persist(st);
        //session.persist(ad);

        tx.commit();

        session.close();
    }
}
