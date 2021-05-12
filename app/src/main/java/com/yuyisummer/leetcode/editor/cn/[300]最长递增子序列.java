package com.yuyisummer.leetcode.editor.cn;
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 二分查找 动态规划 
// 👍 1598 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    /*二分查找，找到nums中，小于key值的数据*/
    public int CeilIndex(int[] nums, int l, int r, int key) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (nums[m] >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        if (size == 0) return 0;
        int[] tailTable = new int[size];
        int len;
        tailTable[0] = nums[0];
        len = 1;

        /*可以这么干的核心是，如果当前位置的数据小于往前回溯的值，
        后面的值如果满足大于回溯值，肯定也会大于当前位置的数据*/
        for (int i = 1; i < size; i++) {
            if (nums[i] < tailTable[0])
                tailTable[0] = nums[i];
            else if (nums[i] > tailTable[len - 1]) {
                tailTable[len++] = nums[i];
            } else {
                tailTable[
                        CeilIndex(tailTable, -1, len - 1, nums[i])]
                        = nums[i];
            }

        }

        return len;
    }


    public int lengthOfLIS_1(int[] nums) {
        /*特殊情况，直接返回*/
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        /*定义数组，进行长度数据的保存*/
        int[] dp = new int[nums.length];
        /*长度从1开始，特殊情况已经排除了*/
        int LIS = 1;
        /*子序列长度最小为1，上面已排除了特殊情况*/
        dp[0] = 1;
        /*需要遍历整个数组，无法避免*/
        for (int i = 1; i < dp.length; i++) {
            /*当前位置任意一个数都可以做为单独的派生子序列，长度为1*/
            dp[i] = 1;
            /*当前位置，进行回溯比较*/
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    /*满足条件，说明在当前位置上多了一种可能的情况*/
                    dp[i] = dp[j] + 1;
                }
                /*比已存在的最大值要大，就可以保存值了*/
                if (dp[i] > LIS) {
                    LIS = dp[i];
                }
            }
        }
        return LIS;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
