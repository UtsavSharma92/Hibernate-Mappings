package com.books.BookApplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.books.BookApplication.domain.Book;
import com.books.BookApplication.service.BookService;

@RestController
public class BookController {

	private static final Logger log = LoggerFactory.getLogger(BookController.class);

	// POST url : /book/submitData
	// GET url : /book/fetchBookData

	@Autowired
	BookService bookService;

	@PostMapping(value = "/book/submitData")
	public String submitBookData(@RequestBody Book book) {

		log.info("Inside submitBookData method");

		String bookData = bookService.saveBookData(book);
		
		log.info("Returning response");

		return bookData;

	}
	
	@GetMapping(value="/book/fetchBookData")
	public Book getBookData(@RequestBody int bookId ) {
		
		log.info("Inside get book data method");
		
		Book book = bookService.getBookData(bookId);
		
		return book;
		
		
	}

}
