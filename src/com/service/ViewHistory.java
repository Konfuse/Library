package com.service;

import com.domain.BorrowHistory;

import java.util.List;

public interface ViewHistory {
    public List<BorrowHistory> view(String reader_name);
}
