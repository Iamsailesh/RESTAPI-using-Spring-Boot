package com.jp.practicerest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.jp.practicerest.entities.Books;
@Component
public class BookService {
	
	private static List<Books> list= new ArrayList<>();
	
	static {
		
		list.add(new Books(11,"Karnali Blues", "Buddhi Sagar"));
		list.add(new Books(12,"Butterfly Dreams", "Anne Mccard"));
		list.add(new Books(13,"Fellowship Point", "Alice Elliott"));
		list.add(new Books(14,"Anna", "Amy Odell"));
		list.add(new Books(115,"Cult Classic", "Sloane Crosley"));
		list.add(new Books(117,"Lapvona", "Ottessa"));
	}
	
	// if get all books 
		public List<Books> getAllBooks(){
			return list;
			}
		
		//if single book is asked
		public Books getBookById(int id) {
			for (Books book : list) {
				if (book.getBid() == id) {
					return book;
				}
			}
			return null; // Return null if the book with the specified ID is not found
		}
		
		//adding book to an array
		public Books postBook(Books b) {
			list.add(b);
			return b;
			
		}
		
		//deleting book of the array
		
		public void deleteBook(int id) {
		    list.removeIf(book -> book.getBid() == id);
		}
		
		//editing the book
		
		public void editBook(Books book, int id) {
			
			list= list.stream().map(e->{
				if(e.getBid()==id){
					e.setBname(book.getBname());
					e.setAuthor(book.getAuthor());
				}
				return e;
					
			}).collect(Collectors.toList());
			
			
		}
	

}
