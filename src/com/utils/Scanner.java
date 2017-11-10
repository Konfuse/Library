package com.utils;

import com.domain.Book;
import com.domain.Reader;

public class Scanner {
    private static String information = null;

    private static String getScanner() {
        return information;
    }

    public static Object dealInfo() {
        String[] infoList = getScanner().split(" ");
        if (infoList.length == 6) {
            return new Book(infoList[0], infoList[1], infoList[2], infoList[3], infoList[4], infoList[5]);
        } else if (infoList.length == 3) {
            return new Reader(infoList[0], infoList[1], infoList[2]);
        } else {
            return null;
        }
    }
}