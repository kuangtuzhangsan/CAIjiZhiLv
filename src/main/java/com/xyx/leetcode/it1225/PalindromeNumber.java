package com.xyx.leetcode.it1225;
//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//
// 例如，121 是回文，而 123 不是。
//
//
//
//
// 示例 1：
//
//
//输入：x = 121
//输出：true
//
//
// 示例 2：
//
//
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
//
// 示例 3：
//
//
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
//
//
//
//
// 提示：
//
//
// -2³¹ <= x <= 2³¹ - 1
//
//
//
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？
//
// Related Topics 数学 👍 2764 👎 0

public class PalindromeNumber {
    public static void main(String[] args) {
        int x1 = 12321;
        int x2 = -121;
        int x3 = 10;

        System.out.println(isPalindrome(x1)); // 输出 true
        System.out.println(isPalindrome(x2)); // 输出 false
        System.out.println(isPalindrome(x3)); // 输出 false
    }

    public static boolean isPalindrome(int x) {
        // 处理负数和以 0 结尾的非零数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedNumber = 0;
        while (x > reversedNumber) {
            int digit = x % 10;
            reversedNumber = reversedNumber * 10 + digit;
            x /= 10;
        }
        System.out.println(reversedNumber);
        System.out.println(x);

        // 当数字长度为奇数时，可以通过 reversedNumber / 10 去掉中间的数字
        return x == reversedNumber || x == reversedNumber / 10;
    }
}
