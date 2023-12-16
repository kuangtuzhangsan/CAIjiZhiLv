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
        for (int left = 0; left < arr.length; left++) {
            // 从第一个索引开始，先向右，
            for (int right = 1; left+right < arr.length && left-right > -1; right++) {
                if (arr[left-right] == arr[left+right] ){
                    if ((2*right + 1) > max){
                        max = 2*right + 1;
                        res = s.substring(left-right,left+right+1);
                    }
                }else {
                    break;
                }
            }

            for (int right = 0; left+right+1 < arr.length && left-right > -1; right++) {
                if (arr[left-right] == arr[left+right+1]  ){
                    if (2 * right+2 > max){
                        max = 2 * right+2;
                        res = s.substring(left-right,left+right+2);
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

    public String longestPalindrome2(String s) {
        if (s.length()==1){
            return s;
        }
        int length = s.length();
        int left = 0;
        int right = 0;
//        for (left;)
        return "";
    }

    // 以下chatgpt
    // 动态规划方法
    public String longestPalindrome3(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLength = 1;

        // 所有长度为 1 的子串都是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 检查长度为 2 的子串
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // 检查长度大于 2 的子串
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = len;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }
    // 中心扩散法
    public String longestPalindrome4(String s) {
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
            //bab4ad
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
