package com.xyx.leetcode;

import java.util.HashSet;

public class LeetCode0308 {
    public boolean canConstruct(String ransomNote, String magazine) {
      /*  // 用hashset 不能重复的特性实现
      *
      * */
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
    }
}
