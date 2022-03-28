package com.books.BookApplication.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;

	private String bookName;

	private int bookPages;

	private String bookAuthor;

	//@OneToOne
	@OneToMany(mappedBy="book",cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
	private List<Chapter> chapter;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookPages() {
		return bookPages;
	}

	public void setBookPages(int bookPages) {
		this.bookPages = bookPages;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public List<Chapter> getChapter() {
		return chapter;
	}

	public void setChapter(List<Chapter> chapter) {
		this.chapter = chapter;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookPages=" + bookPages + ", bookAuthor="
				+ bookAuthor + ", chapter=" + chapter + "]";
	}
	
	

}
