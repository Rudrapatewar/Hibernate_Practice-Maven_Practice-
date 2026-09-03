package com.rudra;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        //get , load
        Configuration config = new Configuration();
        config.configure();
        SessionFactory factory = config.buildSessionFactory();

        Session session= factory.openSession();
        //get-student : 106
        Student student=(Student)session.find(Student.class,103);
        System.out.println(student);

        //get from address
        Address address = (Address)session.find(Address.class,2);
        System.out.println(address.getStreet() + " :" + address.getCity());

        session.close();
        factory.close();
    }
}
