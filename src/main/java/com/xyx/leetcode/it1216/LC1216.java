package com.xyx.leetcode.it1216;

public class LC1216 {
     // 这个有缺陷
    public static String convert(String s, int numys) {
        int length = s.length();
        char[][] matrix = new char[length][numys];
        int y = 0;
        int x = 0 ;
        int index = 0;
        while ( index < length ) {
            if (y == 0){
                for (y = 0 ; y < numys; y++) {
                    if (index<length){
                        matrix[x][y] = s.charAt(index);
                        index ++;
                    }else{
                        break;
                    }
                }
                x++;
            }else {
                if (y == numys){
                    y = numys - 2;
                }
                matrix[x][y] = s.charAt(index);
                index++;
                x++;
                y--;
            }
        }
        StringBuilder res = new StringBuilder();
        for ( y = 0; y < numys ; y++) {
            for ( x = 0; x < length ; x++) {
                if (matrix[x][y] !=  0){
                    res.append(matrix[x][y]);
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println("");
        System.out.println(convert2("PAYPALISHIRING",4 ));
    }

    // chatgpt
    public static String convert2(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int index = 0;
        int direction = 1;

        for (char ch : s.toCharArray()) {
            rows[index].append(ch);

            if (index == 0) {
                direction = 1;
            } else if (index == numRows - 1) {
                direction = -1;
            }

            index += direction;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
