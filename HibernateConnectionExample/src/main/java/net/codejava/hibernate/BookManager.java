package net.codejava.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BookManager {
    protected SessionFactory sessionFactory;

    protected void setup() {
     
        
        // code to load Hibernate Session factory
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure() // configures settings from hibernate.cfg.xml
    	        .build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	}
    }
 
    protected void exit() {
        // code to close Hibernate Session factory
    	sessionFactory.close();
    }
 
    protected void create() {
        // code to save a book
        Book book = new Book();
        book.setTitle("Effective Javtaa");
        book.setAuthor("Joshua Bloctha");
        book.setPrice(32.59f);
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.save(book);
     
        session.getTransaction().commit();
        session.close();
    }
 
    protected void read() {
        BookManager manager = new BookManager();
        manager.setup();
     
        manager.create();
     
        manager.exit();
    }
 
    protected void update() {
        // code to modify a book
        Book book = new Book();
        book.setId(20);
        book.setTitle("Ultimate Java Programmingg");
        book.setAuthor("Nam Ha Mingh");
        book.setPrice(19.999f);
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.update(book);
     
        session.getTransaction().commit();
        session.close();
    }
 
    protected void delete() {
        // code to remove a book
        Book book = new Book();
        book.setId(20);
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.delete(book);
     
        session.getTransaction().commit();
        session.close();
    }
 
    public static void main(String[] args) {
        // code to run the program
        BookManager manager = new BookManager();
        manager.setup();
     
        manager.create();
     
        manager.exit();
    }
}
