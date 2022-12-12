package com.codesimple.library.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codesimple.library.bookservice.entity.Book;

public interface BooksRepository extends JpaRepository<Book, String>{

}