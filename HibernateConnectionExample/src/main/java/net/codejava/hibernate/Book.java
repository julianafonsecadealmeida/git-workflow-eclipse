package net.codejava.hibernate;

import javax.persistence.*;

/**
 * Book.java
 * This class maps to a table in database.
 * @author Juliana Almeida
 *
 */
 
@Entity
@Table(name = "book")
public class Book {
    private long id;
    private String title;
    private String author;
    private float price;
    
    public Book() {
    }
    
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
