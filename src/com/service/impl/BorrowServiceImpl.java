package com.service.impl;

import java.util.Date;

import com.dao.impl.BorrowInforImpl;
import com.service.BorrowService;

public class BorrowServiceImpl implements BorrowService {

	BorrowInforImpl borrowInforImpl = new BorrowInforImpl();

	@Override
	public boolean borrowInfor(String book_id, String reader_name, String time) {
		return (borrowInforImpl.borrowInfor(book_id, reader_name, time));
	}

	@Override
	public boolean returnInfor(String book_id, String borrow_time,String return_time,double payment) {
		return (borrowInforImpl.returnInfor(book_id,borrow_time,return_time, payment));
	}

	@Override
	public Date searchInfor(String book_id) {
		return (borrowInforImpl.searchInfor(book_id));
	}
}
