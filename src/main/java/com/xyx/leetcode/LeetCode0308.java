package com.xyx.leetcode;

import java.util.HashSet;

public class LeetCode0308 {

/*
* */
/*    public boolean canConstruct(String ransomNote, String magazine) {
      *//*  // 用hashset 不能重复的特性实现
      *
      * *//*
        HashSet set = new HashSet();
        for (int i = 0; i < ransomNote.length(); i++) {
            set.add(ransomNote.substring(i,i+1));
        }
        int length = set.size();
        for (int i = 0; i < magazine.length(); i++) {
            set.add(magazine.substring(i,i+1));
        }
        if(set.size() == length)return true;
        return false;
    }*/

    static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("bc","ad")) ;
    }
}
