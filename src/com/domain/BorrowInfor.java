package com.domain;

public class BorrowInfor {
	private Book book = null;
	private String username;

	public BorrowInfor(Book book, String username) {
		this.book = book;
		this.username = username;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
