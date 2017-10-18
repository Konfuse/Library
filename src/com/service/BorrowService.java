package com.service;

public interface BorrowService {
	public void addInfor(String book_name, String reader_name, String time);

	public void deleteInfor(String book_name, String reader_name, String time);
}
