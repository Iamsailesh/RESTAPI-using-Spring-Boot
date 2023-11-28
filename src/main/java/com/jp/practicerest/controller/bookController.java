package com.jp.practicerest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Books>> getBooks(){
		List<Books> list=bookService.getAllBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	//getting specific book
	
	@GetMapping("books/{id}")
	public ResponseEntity<Books> getBookById(@PathVariable("id") int id) {
		Books book= bookService.getBookById(id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();		
			} 
		return ResponseEntity.of(Optional.of(book));
	}
	
	//post handler
	@PostMapping("/books")
	public ResponseEntity<Books> postBook(@RequestBody Books b) {
	    Books c = null;
	    try {
	        c = bookService.postBook(b);
	        return ResponseEntity.status(HttpStatus.CREATED).body(c);
	    } catch (DataIntegrityViolationException e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();  // or another appropriate HTTP status
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
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
	

