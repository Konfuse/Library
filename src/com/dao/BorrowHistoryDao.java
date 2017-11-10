package com.dao;

import com.domain.BorrowHistory;

import java.util.List;

public interface BorrowHistoryDao {
    public List<BorrowHistory> viewHistory(String reader_name);
    public boolean whetherRemind(String reader_name);
}
