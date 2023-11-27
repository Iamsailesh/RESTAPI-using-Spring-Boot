package com.jp.practicerest.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jp.practicerest.dao.BookRepository;
import com.jp.practicerest.entities.Books;
@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public List<Books> getAllBooks(){
		
		
		List<Books> list=this.bookRepo.findAll();
		return list;
		
		
		}
	
	
//	private static List<Books> list= new ArrayList<>();
	
	
//	static {
//		
//		list.add(new Books(11,"Karnali Blues", "Buddhi Sagar"));
//		list.add(new Books(12,"Butterfly Dreams", "Anne Mccard"));
//		list.add(new Books(13,"Fellowship Point", "Alice Elliott"));
//		list.add(new Books(14,"Anna", "Amy Odell"));
//		list.add(new Books(115,"Cult Classic", "Sloane Crosley"));
//		list.add(new Books(117,"Lapvona", "Ottessa"));
//	}
	
	
	// if get all books 
		
		
		//if single book is asked
		public Books getBookById(int id) {
			 Optional<Books> optionalBook = bookRepo.findById(id);

			    // Return the book if present, or null if not present
			    return optionalBook.orElse(null);
			
			
		}
		
		//adding book to an array
		public Books postBook(Books b) {
			Books rslt= bookRepo.save(b);
			return rslt;
			
		}
		
		//deleting book of the array
		
		public void deleteBook(int id) {
		 bookRepo.deleteById(id);
		}
		
		//editing the book
		
		public void editBook(Books book, int id) {
			book.setBid(id);
			
			bookRepo.save(book);
			
		}
	

}
