package org.dxctraining.dao;

import java.util.*;

import org.dxctraining.entities.Book;

public interface IBookDao {

	void addBook(Book book);

//	void bookDetails(Book book);

	void remove(String id);

//	public Book updateBookName(String id, String name);

	public Book findBookById(String id);

	List<Book> findAllBooks();

	Book updateCost(String id, double cost);
}