package com.xyx.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class LeetCode0330 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
    }
    /*
    * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
    * 去重是个错误的想法
    * 使用滑动窗口
    * */
//    2023年7月5日，判断窗口内字符串是否有重复字符即可，窗口从大到小，第一次无重复的时候就是最大的。
    public static int lengthOfLongestSubstring(String s) {
        // 滑动窗口内部的字符串是否是不重复的即可
        // 设置一个初始的窗口长度
        // !!!!!!!执行结果超时了
        char[] arrayChar = null ;
        HashSet newSet = new HashSet<>();
        String str = null ;
        if (s.isEmpty())return 0;
        for ( int i = s.length(); i > 0 ; i-- ) {
            for (int j = 0; i + j <= s.length(); j++) {
                str = s.substring(j, i+j);
                arrayChar = str.toCharArray();
                for(char newChar : arrayChar){
                    newSet.add(newChar);
                }
                if (newSet.size() == i ) {
                    System.out.println(str);
                    return i;
                }
                newSet.removeAll(newSet);
            }
        }
        return 1;
    }


// 官方回答
    static class Solution {
        public static int lengthOfLongestSubstring(String s){
            int[] last = new int[128];
            for(int i = 0; i < 128; i++) {
                last[i] = -1;
            }
            int n = s.length();
            int res = 0;
            int start = 0; // 窗口开始位置
            for(int i = 0; i < n; i++) {
                //ascii码表中的值相同时则说明字符重新出现
                int index = s.charAt(i);
                //last[index]+1表示从下一位数开始
                start = Math.max(start, last[index] + 1);
                //i - start + 1,当前长度
                res   = Math.max(res, i - start + 1);
                //对应ascii码值赋予位置值
                last[index] = i;
            }
            return res;
        }

    }



    public static Boolean isUnique(String str) {
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i))!= null){
                return false;
            } else {
                map.put(str.charAt(i),'a');
            }
        }
        return true;
    }

    // 去重自己写的
    public static String deduplication (String s) {
        char[] array = s.toCharArray();
        HashSet newSet = new HashSet<>();
        for(char newChar : array){
            newSet.add(newChar);
        }
        StringBuffer buffer = new StringBuffer();
        Iterator iterator = newSet.iterator();
        while (iterator.hasNext()){
            buffer.append(iterator.next());
        }
        return buffer.toString();
    }

    //传参：str="qw23eqr123e4tt"
    public String ARFA(String str) {
        //创建一个空字符串用于接收去重后的字符串
        String arfa="";
        //遍历字符串str
        for (int i = 0; i < str.length(); i++) {
            //获取字符串中下标为i的字符（char类型）
            char ch = str.charAt(i);
            //如果字符串没有重复，即：每个字符的下标都会等价于该字符第一次出现时的下标
            //判断字符串第一次出现ch字符时的下标是否等于i
            if (str.indexOf(ch)==i) {
                //将ch字符转化为String类型，并添加到字符串arfa的末尾
                arfa=arfa.concat(String.valueOf(ch));
            }
        }
        return arfa;
    }

    //去重结果：qw23er14t
    public String ARFA2(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i))==i) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     1.将传参str转化为StringBuffer类型
     2.调用reverse()可以将StringBuffer类型sb实现倒序
     3.调用toString()转化为String类型可以调用replaceAll(,)方法
     4.replaceAll("(.)(?=.*\\1)", "")方法可以实现：
     从前往后遍历，某字符出现的第二次，则第一出现的字符会被删除
     5.再次将String类型rs转化为StringBuffer类型，并调用reverse()方法
     实现倒序，调用toString()方法转化为String类型
     **/

    //传参：str="qw23eqr123e4tt"
    public String ARFA3(String str) {
        StringBuffer sb = new StringBuffer(str);
        String rs = sb.reverse().toString().replaceAll("(.)(?=.*\\1)", "");
        StringBuffer out = new StringBuffer(rs);
        return out.reverse().toString();
    }
    //去重结果：qw23er14t

}
