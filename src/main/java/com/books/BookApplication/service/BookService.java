package com.books.BookApplication.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.books.BookApplication.domain.Book;
import com.books.BookApplication.domain.Chapter;
import com.books.BookApplication.repository.BookRepository;
import com.books.BookApplication.repository.ChapterRepository;
import com.books.BookApplication.repository.PaginatedRepository;

@Service
public class BookService {

	private static final Logger log = LoggerFactory.getLogger(BookService.class);

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private ChapterRepository chapterRepository;

	@Autowired
	private PaginatedRepository paginatedRepository;

	public String saveBookData(Book book) {

		log.info("Inside save book data method of BookService class");

		if (book.getChapter() != null) {

			log.info("It contains chapter details, saving it to db");

			for (Chapter chapter : book.getChapter()) {

				chapter.setBook(book);
			}

			book.setChapter(book.getChapter());

			log.info("Chapter details saved successfully");

		}

		bookRepository.save(book);

		log.info("Book data saved successfully");

		return "Book data saved successfully";

	}

	public Book getBookData(int bookId) {

		log.info("Inside get book data method of BookService class");

		Book book = bookRepository.findByBookId(bookId);

		log.info("Printing fetched book object");
		// System.out.println(book.toString());
		return book;

	}

	public List<Book> getBookDataPaginated(int pageNo, int pageSize) {

		log.info("Inside get book data method for pagination and sorting");

		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("bookId").descending());

		Page<Book> book = paginatedRepository.findAll(pageable);

		return book.toList();
		// return book;

	}

}
