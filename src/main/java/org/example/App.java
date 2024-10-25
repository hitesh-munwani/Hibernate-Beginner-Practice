package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Main class to demonstrate a simple Hibernate application.
 */
public class App
{
    public static void main(String[] args)
    {
        // Print a greeting message to the console
        System.out.println("Hello World!");

        // Create a Configuration object to configure Hibernate
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); // Load configuration from hibernate.cfg.xml

        // Build a SessionFactory from the configuration
        SessionFactory factory = cfg.buildSessionFactory();

        // Create a new Student object
        Student st = new Student();
        st.setId(1); // Set ID for the student
        st.setName("Hitesh"); // Set name for the student
        st.setCity("Karachi"); // Set city for the student
        System.out.println(st.toString()); // Print the student object to console

        // Open a new session
        Session session = factory.openSession();

        // Begin a transaction
        Transaction tx = session.beginTransaction();

        // Save the student object to the database
        session.save(st);

        // Commit the transaction to save the changes
        tx.commit();

        // Close the session
        session.close();

        // Close the SessionFactory (optional, but good practice)
        factory.close();
    }
}
