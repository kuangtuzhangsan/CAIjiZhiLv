package com.xyx.leetcode;

public class LeetCode {


    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int[] result = runningSum(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            result[i] = temp;
        }
        return result;
    }
}
