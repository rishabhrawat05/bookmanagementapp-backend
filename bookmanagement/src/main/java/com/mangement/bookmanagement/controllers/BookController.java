package com.mangement.bookmanagement.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mangement.bookmanagement.dto.BookDto;
import com.mangement.bookmanagement.entities.Book;
import com.mangement.bookmanagement.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping("/add")
	public Book addBook(@RequestBody BookDto bookDto) {
		return bookService.addBook(bookDto);
	}
	
	@GetMapping("/getbook/{id}")
	public Book getBookById(@PathVariable String id) {
		return bookService.getBookById(id);
	}
	
	@GetMapping("/getallbooks")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@PutMapping("/update/{id}")
	public Book updateBookById(@PathVariable String id, @RequestBody BookDto bookDto) {
		return bookService.updateBook(id, bookDto);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteBookById(@PathVariable String id) {
		bookService.deleteBookById(id);
	}
}
