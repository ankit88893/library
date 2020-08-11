package org.dxctraining.service;
import org.dxctraining.dao.*; 
import org.dxctraining.entities.*;
import org.dxctraining.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class BookServiceImp implements IBookService {
	@Autowired
	private IBookDao dao;

	@Override
	public Book findBookById(String id) {
		validateId(id);
		Book book = dao.findBookById(id);
		return book;
	}

	@Override
	public void addBook(Book book) {
		dao.addBook(book);
	}

	@Override
	public void remove(String id) {
		validateId(id);
		dao.remove(id);
	}

	@Override
	public Book updateCost(String id, double cost) {
		validateId(id);
		validateCost(cost);
		Book book = dao.updateCost(id, cost);
		return book;
	}
/*
	@Override
	public Book updateBookName(String id, String name) {
		validateId(id);
		validateName(name);
		Book book = dao.updateBookName(id, name);
		return book;
	}
	@Override
	public void bookDetails(Book book) {
		dao.bookDetails(book);
	}
*/
	@Override
	public List<Book> findAllBook() {
		List<Book> book = dao.findAllBooks();
		return book;

	}

	void validateName(String name) {
		if (name == null || name.isEmpty()) {
			throw new InvalidArgumentException("Book name can't be null or empty");
		}
	}

	void validateId(String id) {
		if (id == null || id.isEmpty()) {
			throw new InvalidArgumentException("Book Id can't be null or empty");
		}
	}

	void validateCost(double cost) {
		if (cost < 0) {
			throw new InvalidCostException("cost can not be -ve");
		}

	}



}