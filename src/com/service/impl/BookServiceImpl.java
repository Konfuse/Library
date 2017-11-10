package com.service.impl;

import java.util.List;

import com.dao.BookDao;
import com.dao.impl.BookDaoImpl;
import com.domain.Book;
import com.service.BookService;

public class BookServiceImpl implements BookService {

	BookDao bookdao = new BookDaoImpl();

	@Override
	public List<Book> search(String input) throws Exception {
		return bookdao.searchBook(input);
	}

	@Override
	public boolean addBook(Book book) {
		return bookdao.addBook(book);
	}

	public Boolean searchTheBook(String bookName, String author) {
		return bookdao.searchTheBook(bookName, author);
	}

	public boolean borrow(String book_id, String reader_name) {
		return bookdao.borrowBook(book_id, reader_name);
	}

	public boolean returnBook(String book_id) {
		return bookdao.returnBook(book_id);
	}

	public boolean deleteBook(String id) {
		return bookdao.deleteBook(id);
	}

	public boolean changeLocation(Book book) {
		return bookdao.changeLocation(book);
	}
}
