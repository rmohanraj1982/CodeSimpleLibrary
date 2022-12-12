package com.codesimple.library.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codesimple.library.bookservice.entity.Book;
import com.codesimple.library.bookservice.repository.BooksRepository;

@Service
public class BookService {
	@Autowired
	BooksRepository booksRepository;

	public List<Book> getAllBooks() {
		return booksRepository.findAll();
	}

	public Book getBookById(String bookId) {
		return booksRepository.findById(bookId).get();
	}
	
	public Book saveBook(Book book) {
		return booksRepository.save(book);
	}

	public boolean isAvailable(String bookId) {
		boolean available = false;
		Book book = booksRepository.findById(bookId).get();
		
		if(book != null)
			available=book.getAvailableCopies() > 0;
			
		return available;
	}

	public boolean subscribeBook(String bookId) {
		Book book = booksRepository.findById(bookId).get();
		if (book.availableCopies>0)
			book.availableCopies--;
		return (booksRepository.save(book) != null);
	}
}
