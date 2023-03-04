package com.xyx.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LeetCode0301 {
    public static int maximumWealth(int[][] accounts) {
        /*int[] sumArr = new int[accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            int[] newByte = accounts[i];
            int sum = 0;
            for (int j = 0; j < newByte.length; j++) {
                sum += newByte[j];
            }
            sumArr[i] = sum;
        }
        Arrays.sort(sumArr);

        //官方回答
        return sumArr[sumArr.length-1];*/
        /*int maxWealth = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            maxWealth = Math.max(maxWealth, Arrays.stream(account).sum());
        }
        return maxWealth;*/

        return Arrays.stream(accounts).map(Arrays::stream).mapToInt(IntStream::sum).reduce(0, Math::max);
    }

    public static void main(String[] args) {
        int[][] arr={{1,2,3},{3,7,1},{3,7,6},{3,7,3}};
        int abc = maximumWealth(arr);
        System.out.println(abc);
    }
}
