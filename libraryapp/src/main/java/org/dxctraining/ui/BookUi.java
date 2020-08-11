package org.dxctraining.ui;
import org.dxctraining.entities.*;  
import org.dxctraining.exceptions.*;
import org.dxctraining.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import javax.annotation.PostConstruct;



@Component
public class BookUi {
	@Autowired
	private IBookService bookService;
	
	public static void main(String[] args) {
		BookUi demo = new BookUi();
		demo.runApp();
	}
@PostConstruct
	public void runApp() {

		try {
			Author author1 = new Author("let us c", "yashwant");
			Author author2 = new Author("java", "arun sharma");
			Author author3 = new Author("spanish", "lord of the rings");
			Author author4 = new Author("harry potter", "jk rowling");

			Book book1 = new Book("1", "ankit", 200, author1);
			Book book2 = new Book("2", "anoop", 600, author2);
			Book book3 = new Book("3", "ankur", 900, author3);
			Book book4 = new Book("4", "anil", 500, author4);
			
			
			bookService.addBook(book1);
			bookService.addBook(book2);
			bookService.addBook(book3);
			bookService.addBook(book4);
			

		} catch (BookNotFoundException e) {
			//String msg = e.getMessage();
			//System.out.print(msg);
			e.printStackTrace();
			System.out.println("book not found exceptiion");
		} catch (InvalidArgumentException e) {
			String msg = e.getMessage();
			System.out.print(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		displayAll();
	}

	public void displayAll() {
		List<Book> list = bookService.findAllBook();
		for (Book book : list) {
			display(book);
		}
	}

	public void display(Book book) {
		System.out.println("book:- " + book.getId() + "\n name:-" + book.getName() +"\n cost:-"+ book.getCost());
		Author author = book.getAuthor();
		System.out.println("Author " + author.getName() + " \nId=" + author.getId());

	}
}