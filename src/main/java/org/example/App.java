package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.stream.Stream;

/**
 * Main class to demonstrate a simple Hibernate application.
 */
public class App {
    public static void main(String[] args) throws IOException {
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

        // Create a new obj of Address Class
        Address ad = new Address();
        ad.setStreet("street1");
        ad.setCity("Karachi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(11.25);
        FileInputStream fis = new FileInputStream("src/main/java/org/example/pixel.jpg");
        byte[] data = fis.readAllBytes();
        ad.setImage(data);
        System.out.println(ad.toString());

        // Open a new session
        Session session = factory.openSession();

        // Begin a transaction
        Transaction tx = session.beginTransaction();

        // Save the student object to the database
        session.save(st);
        session.save(ad);

        // Commit the transaction to save the changes
        tx.commit();

        // Close the session
        session.close();

        // Close the SessionFactory (optional, but good practice)
        factory.close();
    }
}
