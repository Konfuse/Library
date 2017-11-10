package com.dao;

import java.util.List;

import com.domain.Book;

public interface BookDao {
	public List<Book> searchBook(String input) throws Exception;

	public Boolean searchTheBook(String bookName,String author);

	public boolean addBook(Book book);

	public boolean borrowBook(String book_id,String reader_name);

	public boolean returnBook(String book_id);

	public boolean deleteBook(String id);

	public boolean changeLocation(Book book);
}
