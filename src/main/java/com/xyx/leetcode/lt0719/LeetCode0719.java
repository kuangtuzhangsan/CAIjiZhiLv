package com.xyx.leetcode.lt0719;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。

算法的时间复杂度应该为 O(log (m+n)) 。
示例 1：
输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：
输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class LeetCode0719 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //返回值
        double v = 0.0;
        //数组元素转换为数值流
        IntStream s = Arrays.stream(nums1);
        //流中元素全部装箱
        Stream<Integer> st = s.boxed();
        //将流转换为数组
        Integer[] num1 = st.toArray(Integer[]::new);
        s = Arrays.stream(nums2);
        st = s.boxed();
        Integer[] num2 = st.toArray(Integer[]::new);
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(Arrays.asList(num1));
        list.addAll(Arrays.asList(num2));
        java.util.Collections.sort(list);
        int len = list.size();
        if(len%2!=0) {
            v = Double.valueOf(list.get((len+1)/2-1));
        } else {
            int n = list.get(len/2-1)+list.get((len)/2);
            v = Double.valueOf(n)/2;
        }
        return v;
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("周杰伦");
        list.add("王力宏");
        list.add("陶喆");
        list.add("林俊杰");
        Stream<Integer> stream = list.stream().map(String::length);
        stream.forEach(System.out::println);
    }
}
