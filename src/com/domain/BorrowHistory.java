package com.domain;

public class BorrowHistory {
    private String book_name;
    private String author_name;
    private String borrow_time;
    private String should_r_time;
    private String return_time;
    private Double pay_money;
    private String borrow_flag;


    public BorrowHistory(String book_name, String author_name, String borrow_time, String should_r_time, String return_time, Double pay_money, String borrow_flag) {
        this.book_name = book_name;
        this.author_name = author_name;
        this.borrow_time = borrow_time;
        this.should_r_time = should_r_time;
        this.return_time = return_time;
        this.pay_money = pay_money;
        this.borrow_flag = borrow_flag;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setReturn_time(String return_time) {
        this.return_time = return_time;
    }

    public void setPay_money(Double pay_money) {
        this.pay_money = pay_money;
    }

    public String getReturn_time() {
        return return_time;
    }

    public Double getPay_money() {
        return pay_money;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public void setBorrow_time(String borrow_time) {
        this.borrow_time = borrow_time;
    }

    public void setShould_r_time(String should_r_time) {
        this.should_r_time = should_r_time;
    }

    public void setBorrow_flag(String borrow_flag) {
        this.borrow_flag = borrow_flag;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getBorrow_time() {
        return borrow_time;
    }

    public String getShould_r_time() {
        return should_r_time;
    }

    public String getBorrow_flag() {
        return borrow_flag;
    }
}
