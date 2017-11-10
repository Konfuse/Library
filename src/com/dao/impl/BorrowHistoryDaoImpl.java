package com.dao.impl;

import com.dao.BorrowHistoryDao;
import com.domain.BorrowHistory;
import com.utils.DBUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.sql.*;
import java.util.List;

public class BorrowHistoryDaoImpl implements BorrowHistoryDao {

    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public List<BorrowHistory> viewHistory(String reader_name) {
        List<BorrowHistory> borrowHistories = new ArrayList<>();
        BorrowHistory borrowHistory = null;
        String should_r_time = null;
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "SELECT * FROM (borrow_infor JOIN book_id using (book_id)) NATURAL LEFT OUTER JOIN return_infor WHERE reader_name = ?";
        try{
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,reader_name);
            rs = pstmt.executeQuery();
            while (rs.next()) {
//                rs.previous();
//                BeanListHandler<BorrowHistory> bh = new BeanListHandler<BorrowHistory>(BorrowHistory.class);
//                borrowHistories = bh.handle(rs);
                date = format.parse(rs.getString(3));
                cal.setTime(date);
                cal.add(Calendar.DATE,45);
                date = cal.getTime();
                should_r_time = format.format(date);
                borrowHistory = new BorrowHistory(rs.getString(5),rs.getString(6),rs.getString(3),should_r_time,rs.getString(8),rs.getDouble(9),rs.getString(4));
                borrowHistories.add(borrowHistory);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(rs, stmt, pstmt, conn);
        }
        return borrowHistories;
    }

    @Override
    public boolean whetherRemind(String reader_name){

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String sql = "SELECT borrow_time FROM borrow_infor WHERE reader_name = ? AND borrow_flag = 1";
        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,reader_name);
            rs = pstmt.executeQuery();
            while (rs.next()){
                Date borrow_time = dateFormat.parse(rs.getString(1));
                long days = now.getTime()/(24 * 60 * 60 * 1000) - borrow_time.getTime()/(24 * 60 * 60 * 1000);
                if (days > 45){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(rs, stmt, pstmt, conn);
        }
        return false;
    }
}
