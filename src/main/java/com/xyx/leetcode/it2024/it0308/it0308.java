package com.xyx.leetcode.it2024.it0308;

import java.util.Arrays;

public class it0308 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m+n == 1){
            if (n==0){
                return;
            }
            nums1[0] = nums2[0];
        }
        for (int i = 0; i < n; i++) {
            nums1[i+m] = nums2[i];
        }
        Arrays.sort(nums1);
    }
    // chatgpt

    /**
     *
     这是一种合并排序数组的算法，也可以称为合并排序。它的基本思想是通过比较两个已经排序的数组（在这里是 nums1 和 nums2），然后将它们合并成一个排序的数组。

     具体来说，这个算法使用了双指针法，从两个数组的末尾开始向前遍历，每次选择两个数组中较大的元素放入新数组的末尾，同时向前移动指针。这种方法能够保证合并后的数组仍然是有序的。

     由于在每次操作中只需一次比较和移动操作，因此时间复杂度是 O(m + n)，其中 m 和 n 分别是两个数组的长度。
     */
    public class MergeSortedArray {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1;
            int p2 = n - 1;
            int p = m + n - 1;

            while (p1 >= 0 && p2 >= 0) {
                if (nums1[p1] > nums2[p2]) {
                    nums1[p--] = nums1[p1--];
                } else {
                    nums1[p--] = nums2[p2--];
                }
            }

            while (p2 >= 0) {
                nums1[p--] = nums2[p2--];
            }
        }
    }

}
