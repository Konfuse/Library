package com.service;

import java.util.List;

import com.domain.Book;

public interface BookService {
	public List<Book> search(String input) throws Exception;

	public boolean addBook(Book book);

	public Boolean searchTheBook(String bookName,String author);

	public boolean borrow(String book_id, String reader_name);

	public boolean returnBook(String book_id);

	public boolean deleteBook(String id);

	public boolean changeLocation(Book book);
}