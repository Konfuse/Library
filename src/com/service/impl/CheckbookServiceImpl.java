package com.service.impl;

import com.dao.BorrowHistoryDao;
import com.dao.impl.BorrowHistoryDaoImpl;
import com.service.CheckbookService;

public class CheckbookServiceImpl implements CheckbookService {

    private BorrowHistoryDao bhd = new BorrowHistoryDaoImpl();

    @Override
    public boolean checkbook(String reader_name) {
        return bhd.whetherRemind(reader_name);
    }
}
