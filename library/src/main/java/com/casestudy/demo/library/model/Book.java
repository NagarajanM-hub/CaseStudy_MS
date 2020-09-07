package com.casestudy.demo.library.model;

import javax.persistence.*;

@Entity
@Table(name="BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOK_ID")
	private long id;
    
    @Column(name = "BOOK_NAME")
	private String bookName;
    
    @Column(name = "AUTHOR")
	private String author;
    
    @Column(name = "AVAILABLE_COPIES")
	private int availableCopies;
    
    @Column(name = "TOTAL_COPIES")
	private int totalCopies;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}

	public int getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}
    
}
