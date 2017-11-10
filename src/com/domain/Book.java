package com.domain;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	private String book_id;
	private String book_name;
	private String author;
	private String publishing;
	private String publishing_time;
	private String isbn;
	private int can_borrow = 1;
	private int borrow_flag = 0;
	private String location;

	public Book() {
	}

	public Book(String book_id, String book_name, String author, String publishing, String publishing_time, String isbn) {
		this.book_id = book_id;
		this.book_name = book_name;
		this.author = author;
		this.publishing = publishing;
		this.publishing_time = publishing_time;
		this.isbn = isbn;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishing() {
		return publishing;
	}

	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}

	public String getPublishing_time() {
		return publishing_time;
	}

	public void setPublishing_time(String publishing_time) {
		this.publishing_time = publishing_time;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getCan_borrow() {
		return can_borrow;
	}

	public void setCan_borrow(int can_borrow) {
		this.can_borrow = can_borrow;
	}

	public int getBorrow_flag() {
		return borrow_flag;
	}

	public void setBorrow_flag(int borrow_flag) {
		this.borrow_flag = borrow_flag;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
