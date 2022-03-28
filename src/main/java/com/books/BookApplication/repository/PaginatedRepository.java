package com.books.BookApplication.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.books.BookApplication.domain.Book;

@Repository
public interface PaginatedRepository extends PagingAndSortingRepository<Book, Integer> {

}
