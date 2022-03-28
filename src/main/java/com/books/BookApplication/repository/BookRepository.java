package com.books.BookApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.BookApplication.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	public Book findByBookId(int id);

}
