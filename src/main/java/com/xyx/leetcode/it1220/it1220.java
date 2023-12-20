package com.xyx.leetcode.it1220;

public class it1220 {
    // chatgpt反转整数
    public static void main(String[] args) {
        int number = -12345;
        int reversedNumber = reverseInteger(number);

        System.out.println("Original Number: " + number);
        System.out.println("Reversed Number: " + reversedNumber);
    }

    public static int reverseInteger(int x) {
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;  // 取末尾数字
            x /= 10;  // 移除末尾数字

            // 检查溢出
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;  // 溢出返回0
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;  // 溢出返回0
            }

            reversed = reversed * 10 + digit;  // 构建反转后的数字
        }

        return reversed;
    }

    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int reversed = 0;
        int coefficient = 1;
        for (char a :chars){
            int digit = Character.getNumericValue(a);
            if (a == 45 ){
                coefficient = -1;
            }
            if ( 47< a && a < 58 ){
                // 检查溢出
                if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                    return 0;  // 溢出返回0
                }
                if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                    return 0;  // 溢出返回0
                }
                reversed = reversed * 10 + digit;
            }
        }
        return reversed * coefficient;
    }
}

