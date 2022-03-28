package com.books.BookApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.BookApplication.domain.Chapter;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter,Integer> {

}
