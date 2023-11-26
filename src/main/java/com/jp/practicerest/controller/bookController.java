package com.jp.practicerest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jp.practicerest.entities.Books;
import com.jp.practicerest.services.BookService;

@RestController
public class bookController {
	@Autowired
	private BookService bookService ;
	//getting handler
	@GetMapping("/books")
	public List<Books> getBooks(){
		return this.bookService.getAllBooks();
		
	}
	
	//getting specific book
	
	@GetMapping("books/{id}")
	public Books getBookById(@PathVariable("id") int id) {
		return bookService.getBookById(id);
		
	}
	
	//post handler
	@PostMapping("/books")
	public Books postBook(@RequestBody Books b) {
		Books c= this.bookService.postBook(b);
		return c;
	}
	//delete handler
	@DeleteMapping("/books/{id}")
	public void delete(@PathVariable("id") int id) {
		bookService.deleteBook(id); 
	}
	
	@PutMapping("/books/{id}")
	public void updateBook(@RequestBody Books book,@PathVariable("id") int id) {
		this.bookService.editBook(book,id);
		
	}
		
	
}
	

