package ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;

import java.util.ArrayList;
import java.util.List;

public class ManyToManyMapDemo {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory factory =configuration.buildSessionFactory();

        //creating the employee
        Employee employee1 = new Employee();
        employee1.setEid(101);
        employee1.setName("Ram");

        Employee employee2 = new Employee();
        employee2.setEid(102);
        employee2.setName("Shyam");

        //creating the Projects
        Project project1 = new Project();
        project1.setPid(1);
        project1.setProjectName("Library Management");

        Project project2 = new Project();
        project2.setPid(2);
        project2.setProjectName("ChatBot");

        //creating list
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        List<Project> projects = new ArrayList<>();
        projects.add(project1);
        projects.add(project2);

        //
        employee1.setProjects(projects);

        project2.setEmployees(employees);

        //Session
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        //save
        session.persist(employee1);
        session.persist(employee2);

        session.persist(project1);
        session.persist(project2);


        tx.commit();
        session.close();
        factory.close();
    }
}
