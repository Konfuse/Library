package com.service.impl;

import com.dao.BorrowHistoryDao;
import com.dao.impl.BorrowHistoryDaoImpl;
import com.domain.BorrowHistory;
import com.service.ViewHistory;

import java.util.List;

public class ViewHistoryImpl implements ViewHistory {

    private BorrowHistoryDao borrowHistory = new BorrowHistoryDaoImpl();

    @Override
    public List<BorrowHistory> view(String reader_name) {
        List<BorrowHistory> bh = borrowHistory.viewHistory(reader_name);
        if (bh != null){
            for (BorrowHistory temp:bh) {
                if (temp.getBorrow_flag().equals("1")){
                    temp.setBorrow_flag("Not Returned");
                }
                else{
                    temp.setBorrow_flag("Returned");
                }
                if (temp.getReturn_time() == null){
                    temp.setReturn_time(" ");
                }
                if (temp.getPay_money() == null){
                    temp.setPay_money(0.0);
                }
            }
        }
        return bh;
    }
}
