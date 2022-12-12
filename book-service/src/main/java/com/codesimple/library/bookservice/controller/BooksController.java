package com.codesimple.library.bookservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesimple.library.bookservice.entity.Book;
import com.codesimple.library.bookservice.service.BookService;

@RestController
@RequestMapping("/books")

public class BooksController {
	@Autowired
	BookService bookService;

	
	@GetMapping()
    public ResponseEntity<List<Book>> getBooks(){
		return new ResponseEntity<List<Book>>(bookService.getAllBooks(), HttpStatus.OK);
    }

	@GetMapping("{bookId}")
    public ResponseEntity<Book>  getBookById(@PathVariable String bookId){
		return new ResponseEntity<Book>(bookService.getBookById(bookId), HttpStatus.OK);
    }
	
	@PostMapping()
    public ResponseEntity<Book>  createBook(@RequestBody Book book){
		return new ResponseEntity<Book>(bookService.saveBook(book), HttpStatus.CREATED);
    }

	@PutMapping()
    public ResponseEntity<Book>  updateBook(@RequestBody Book book){
		return new ResponseEntity<Book>(bookService.saveBook(book), HttpStatus.OK);
    }
	
    @GetMapping("{bookId}/availableforsubscription")
    public ResponseEntity<Boolean> isAvailable(@PathVariable String bookId){
        return new ResponseEntity<Boolean>(bookService.isAvailable(bookId), HttpStatus.OK);
    }
    
    @PostMapping("{bookId}/subscribe")
    public ResponseEntity<Boolean> subscribeBook(@PathVariable String bookId){
    	return new ResponseEntity<Boolean>(bookService.subscribeBook(bookId), HttpStatus.CREATED);
    }
}
