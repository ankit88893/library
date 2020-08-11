package org.dxctraining.dao;
import org.dxctraining.entities.*;
import org.dxctraining.exceptions.BookNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookDaoImp implements IBookDao{
	private Map<String, Book> store = new HashMap<>();

	private int generateId;

	   String generateId(){
	        generateId++;
	        String strId=""+generateId;
	        return strId;
	    }

	
	@Override
	public Book findBookById(String id) {
		boolean exists = store.containsKey(id);
		if (!exists) {
			throw new BookNotFoundException("Book not Found of id " + id);
		}
		Book book = store.get(id);
		return book;

	}
	@Override
	public void addBook(Book book) {
		String id = generateId();
		store.put(id, book);
		book.setId(id);
	}


	public List<Book> findAllBooks() {
		Collection<Book> values = store.values();
		List<Book> list = new ArrayList<>();
		for (Book book : values) {
			list.add(book);
		}
		return list;
	}

	/*

	@Override
	public void bookDetails(Book book) {
		String detail = book.getId();
		store.get(detail);
	}

*/
	@Override
	public void remove(String id) {
		store.remove(id);

	}

	@Override
	public Book updateCost(String id, double cost) {
		Book book = findBookById(id);
		book.setCost(cost);
		return book;
	}
/*
	@Override
	public Book updateBookName(String id, String name) {
		Book  book = findBookById(id);
		book.setName(name);
		return book;
	}

*/
	

}