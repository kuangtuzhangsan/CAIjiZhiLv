package com.xyx.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode0316 {
    public static int[] twoSum(int[] nums, int target) {
        int[] result =null;
        for (int indexA =0; indexA < nums.length-1; indexA++) {
            for (int indexB = indexA+1; indexB < nums.length; indexB++) {
                if ((nums[indexA]+nums[indexB])==target) result = new int[]{indexA, indexB} ;
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        ;
        int[] ints = twoSum(new int[]{3,3,3,3,3,8,9}, 6);
        for ( int a:
                ints) {
            System.out.println(a);
        }
    }




    // 官方解答2：用hash表，检查目标数值减去遍历值是否存在
    // 复杂度分析
    //
    //时间复杂度：
    //�
    //(
    //�
    //)
    //O(N)，其中
    //�
    //N 是数组中的元素数量。对于每一个元素 x，我们可以
    //�
    //(
    //1
    //)
    //O(1) 地寻找 target - x。
    //
    //空间复杂度：
    //�
    //(
    //�
    //)
    //O(N)，其中
    //�
    //N 是数组中的元素数量。主要为哈希表的开销。
    //
    //作者：LeetCode-Solution
    //链接：https://leetcode.cn/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int[] twoSumOfficial(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
