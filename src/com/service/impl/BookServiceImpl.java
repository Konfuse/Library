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
		boolean state = false;

		if (bookdao.searchTheBook(book.getBook_name())) {
			state = bookdao.returnBook(book.getBook_name(), book.getNum());
		} else {
			state = bookdao.addBook(book);
		}

		return state;
	}

	public Boolean searchTheBook(String bookName) {
		return bookdao.searchTheBook(bookName);

	}

	public boolean borrow(String bookName) {
		return bookdao.borrowBook(bookName);

	}

	public boolean returnBook(String bookName, int count) {
		return bookdao.returnBook(bookName, count);

	}

}
