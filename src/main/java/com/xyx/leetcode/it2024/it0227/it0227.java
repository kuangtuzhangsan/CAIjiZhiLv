package com.xyx.leetcode.it2024.it0227;

import java.util.Arrays;
import java.util.List;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
//
// Related Topics 字典树 字符串 👍 3062 👎 0
public class it0227 {
    public static String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < 200; i++) {
            if (strs[0].length() > i){
                char currentChar = strs[0].charAt(i);
                for (int j = 0; j < strs.length; j++) {
                    if (strs[j].length() > i && currentChar == strs[j].charAt(i)){

                    }else {
                        return strs[0].substring(0,i);
                    }
                }
            }else {
                return strs[0].substring(0,i);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] strs = {"ab","a"} ;
        System.out.println(longestCommonPrefix(strs));
    }
}
