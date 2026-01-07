package com.xyx.leetcode.it2024.it0104;
// 盛最多水的容器
//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 返回容器可以储存的最大水量。
//
// 说明：你不能倾斜容器。
//
//
//
// 示例 1：
//
//
//
//
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
// 示例 2：
//
//
//输入：height = [1,1]
//输出：1
//
//
//
//
// 提示：
//
//
// n == height.length
// 2 <= n <= 10⁵
// 0 <= height[i] <= 10⁴
//
//
// Related Topics 贪心 数组 双指针 👍 4768 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class LT0104 {
    /**
     * 自己写的
     * > 2024/01/04 10:48:50
     * 解答成功:
     * 	执行耗时:4 ms,击败了60.67% 的Java用户
     * 	内存消耗:56.6 MB,击败了5.04% 的Java用户
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length-1;
        int n = right - left;
        int max = n * (Math.min(height[left],height[right]));
        while (left != right){
            n = right - left;
            if ( height[left] <= height[right]) {
                max = Math.max(max, n * (Math.min(height[left],height[right])));
                left += 1;
            }else {
                max = Math.max(max, n * (Math.min(height[left],height[right])));
                right -= 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    /**
     * > 2024/01/04 10:52:29
     * 解答成功:
     * 	执行耗时:4 ms,击败了60.67% 的Java用户
     * 	内存消耗:56.8 MB,击败了5.04% 的Java用户
     * @param height
     * @return
     */
    public int maxAreaChatgpt(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            maxArea = Math.max(maxArea, h * w);

            // 移动较小高度的指针，以期望找到更大的容量
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
