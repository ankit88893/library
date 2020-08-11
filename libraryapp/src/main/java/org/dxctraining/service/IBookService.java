package org.dxctraining.service;

import org.dxctraining.entities.Book;

import java.util.List;

public interface IBookService {

	public void addBook(Book book);

	//public void bookDetails(Book book);

	public void remove(String id);

	public Book updateCost(String id, double cost);
	
//	public Book updateBookName(String id,String Name);

	public Book findBookById(String id);

	 List<Book> findAllBook();
	
}