package com.xyx.leetcode.it1220;

public class it1220_2 {

    //字符串转换成整数
    // 理解有错误。
    public static int myAtoi(String s) {
        s =s.trim();
        if (s.isEmpty()){
            return 0;
        }
        char[] chars = s.toCharArray();
        int reversed = 0;
        // 正负系数
        int coefficient = 1;
        if (s.contains("-")){
            coefficient = -1;
        }
        for (char a :chars){
            if ( 47< a && a < 58 ){
                int digit = Character.getNumericValue(a) * coefficient;
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
        return reversed;
    }

    public static int myAtoi2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int index = 0;
        int sign = 1;
        int result = 0;

        // Step 1: Skip leading whitespaces
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        // Step 2: Handle optional sign
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index++) == '-') ? -1 : 1;
        }

        // Step 3: Process digits
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Check for integer overflow
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi2(" words and - 987"));
    }
}
