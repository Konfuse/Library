package com.service;

import java.util.List;

import com.domain.Book;

public interface BookService {
	public List<Book> search(String input) throws Exception;

	public boolean addBook(Book book);

	public Boolean searchTheBook(String bookName);

	public boolean borrow(String bookName);

	public boolean returnBook(String bookName, int count);
}