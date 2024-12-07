package com.mangement.bookmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mangement.bookmanagement.dto.BookDto;
import com.mangement.bookmanagement.entities.Book;
import com.mangement.bookmanagement.exceptions.BookNotFoundException;
import com.mangement.bookmanagement.repositories.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public Book addBook(BookDto bookDto) {
		Book book = new Book();
		book.setName(bookDto.getName());
		book.setAuthor(bookDto.getAuthor());
		book.setGenre(bookDto.getGenre());
		book.setPrice(bookDto.getPrice());
		bookRepository.save(book);
		return book;
	}
	
	public Book getBookById(String id) {
		Optional<Book> bookOpt = bookRepository.findById(id);
		if(bookOpt.isEmpty()) {
			throw new BookNotFoundException("Book Not Found!!");
		}
		return bookOpt.get();
	}
	
	public List<Book> getAllBooks(){
		List<Book> bookList = bookRepository.findAll();
		if(bookList.isEmpty()) {
			throw new BookNotFoundException("There are no books!!");
		}
		return bookList;
	}
	
	public Book updateBook(String id, BookDto bookDto) {
		Optional<Book> bookOpt = bookRepository.findById(id);
		if(bookOpt.isEmpty()) {
			throw new BookNotFoundException("Book Not Found!!");
		}
		Book book = bookOpt.get();
		if(bookDto.getAuthor() != null) {
			book.setAuthor(bookDto.getAuthor());
		}
		if(bookDto.getGenre() != null) {
			book.setGenre(bookDto.getGenre());
		}
		if(bookDto.getName() != null) {
			book.setName(bookDto.getName());
		}
		if(bookDto.getPrice() != 0.0) {
			book.setPrice(bookDto.getPrice());
		}
		bookRepository.save(book);
		return book;
	}
	
	public void deleteBookById(String id) {
		Optional<Book> bookOpt = bookRepository.findById(id);
		if(bookOpt.isEmpty()) {
			throw new BookNotFoundException("Book Not Found!!");
		}
		Book book = bookOpt.get();
		bookRepository.delete(book);
	}
}
