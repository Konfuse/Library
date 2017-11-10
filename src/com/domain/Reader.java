package com.domain;

public class Reader {
    private String reader_id;
    private String reader_name;
    private String reader_sex;
    private String reader_email;
    private String reader_phone;

    public Reader() {
    }

    public Reader(String reader_id, String reader_name, String reader_sex) {
        this.reader_id = reader_id;
        this.reader_name = reader_name;
        this.reader_sex = reader_sex;
    }

    public String getReader_id() {
        return reader_id;
    }

    public void setReader_id(String reader_id) {
        this.reader_id = reader_id;
    }

    public String getReader_name() {
        return reader_name;
    }

    public void setReader_name(String reader_name) {
        this.reader_name = reader_name;
    }

    public String getReader_sex() {
        return reader_sex;
    }

    public void setReader_sex(String reader_sex) {
        this.reader_sex = reader_sex;
    }

    public String getReader_email() {
        return reader_email;
    }

    public void setReader_email(String reader_email) {
        this.reader_email = reader_email;
    }

    public String getReader_phone() {
        return reader_phone;
    }

    public void setReader_phone(String reader_phone) {
        this.reader_phone = reader_phone;
    }
}
