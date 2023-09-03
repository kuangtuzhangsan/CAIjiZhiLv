package com.xyx.datetoString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToString {
    public static void main(String[] args) throws ParseException {
        /*String res = longestPalindrome("babad");
        System.out.println(res);*/
        Date currentDate = new Date();
        System.out.println(currentDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String formattedDate = sdf.format(currentDate);
        System.out.println("Formatted Date: " + formattedDate);
        Date date = sdf.parse(formattedDate);
        System.out.println(date);
    }
}
