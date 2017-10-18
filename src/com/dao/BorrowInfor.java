package com.dao;

public interface BorrowInfor {
	public void add(String book_name, String reader_name, String time);

	public void delete(String book_name, String reader_name, String time);
}
