package com.xyx.leetcode.it0822;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LC0822 {
    /**
     * 最长回文字符串
     * @param s "caaaa" "aba"
     * @return
     */
    public static String longestPalindrome(String s){
        // 放置一个分割线，分割线从索引坐标1开始
        char[] arr = s.toCharArray();
        if (arr.length == 1){
            return s;
        }
        int max = 1;
        int startIndex = 0;
        int endIndex  = 0;
        // 左边最大索引长度是索引，右边最大索引长度是 lenth-索引-1
        for (int i = 1; i < arr.length-1; i++) {

        }
        String res = new String(arr,startIndex,endIndex-startIndex+1);
        return res;
    }

    public static void main(String[] args) throws ParseException {
        String res = longestPalindrome("babad");
        System.out.println(res);
    }
}
