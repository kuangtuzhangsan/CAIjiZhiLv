package com.xyx;

public class Code20230228 {
    public static int numberOfSteps(int num) {
        int times  = 0;
        while (num != 0 ){
            if (num % 2== 0){
                num = num/2;
            }else {
                num -= 1;
            }
            times ++ ;
        }
        return times;
    }

    public static void main(String[] args) {
        int times = numberOfSteps(123);
        System.out.println(times);
    }
}
