package com.xyx.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class LeetCode0327 {
    public boolean containsDuplicate(int[] nums) {
        // 自己写的
        /*HashSet<Integer> newSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            newSet.add(nums[i]);
        }
        if (newSet.size() < nums.length) return true;
        return false;*/

        // 题解：contains
        /*HashSet<Integer> newSet = new HashSet<>();
        for (int num :nums) {
            if (newSet.contains(num)){
                return true;
            }
            newSet.add(num);
        }
        return false;*/
        // 思路：先排序，然后循环数组，判断相邻元素是否相同  复杂度：时间复杂度O(nlogn)，空间复杂度O(logn)，排序需要的栈空间
        Arrays.sort(nums);; //会检查数组个数大于286且连续性好就使用归并排序，若小于47使用插入排序，其余情况使用双轴快速排序
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
