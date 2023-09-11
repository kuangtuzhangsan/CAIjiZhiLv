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
    public static String longestPalindrome(String s) {
        if (s.length() == 1){
            return s;
        }
        char[] arr = s.toCharArray();
//        String res = new String(arr,startIndex,endIndex-startIndex+1);
        String res = String.valueOf(arr[0]);
        int max = 1;
        // 左边最大索引长度是索引，右边最大索引长度是 lenth-索引-1
        for (int i = 0; i < arr.length; i++) {
            // 从第一个索引开始，先向右，
            for (int j = 1; i+j < arr.length && i-j > -1; j++) {
                if (arr[i-j] == arr[i+j] ){
                    if ((2*j + 1) > max){
                        max = 2*j + 1;
                        res = s.substring(i-j,i+j+1);
                    }
                }else {
                    break;
                }
            }

            for (int j = 0; i+j+1 < arr.length && i-j > -1; j++) {
                if (arr[i-j] == arr[i+j+1]  ){
                    if (2 * j+2 > max){
                        max = 2 * j+2;
                        res = s.substring(i-j,i+j+2);
                    }
                }else {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws ParseException {
        String res = longestPalindrome("aaaaaaababad");// ac, a
        System.out.println(res);
    }
}
