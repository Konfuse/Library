package com.dao;

import java.util.List;

import com.domain.Book;

public interface BookDao {
	public List<Book> searchBook(String input) throws Exception;

	public Boolean searchTheBook(String bookName);

	public boolean addBook(Book book);

	public boolean borrowBook(String bookName);

	public boolean returnBook(String bookName, int count);
}
