package com.service.impl;

import com.dao.impl.BorrowInforImpl;
import com.service.BorrowService;

public class BorrowServiceImpl implements BorrowService {

	BorrowInforImpl borrowInforImpl = new BorrowInforImpl();

	@Override
	public void addInfor(String book_name, String reader_name, String time) {
		borrowInforImpl.add(book_name, reader_name, time);
	}

	@Override
	public void deleteInfor(String book_name, String reader_name, String time) {
		// TODO Auto-generated method stub

	}

}
