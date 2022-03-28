package com.books.BookApplication.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Chapter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int chapterId;
	
	private String chapterName;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	@JsonIgnore
	private Book book;
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	private int chapterPages;
	
	private String chapterDescription;

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public int getChapterPages() {
		return chapterPages;
	}

	public void setChapterPages(int chapterPages) {
		this.chapterPages = chapterPages;
	}

	public String getChapterDescription() {
		return chapterDescription;
	}

	public void setChapterDescription(String chapterDescription) {
		this.chapterDescription = chapterDescription;
	}

	@Override
	public String toString() {
		return "Chapter [chapterId=" + chapterId + ", chapterName=" + chapterName + ", book=" + book + ", chapterPages="
				+ chapterPages + ", chapterDescription=" + chapterDescription + "]";
	}
	
	
	
	

}
