package com.yuyisummer.leetcode.editor.cn;//给你一个 只包含正整数 的 非空 数组 nums 。
// 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 动态规划 
// 👍 778 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        /*不可能分成两个子集*/
        if (n < 2) {
            return false;
        }

        /*这里涉及到一个知识点，如果 sum 是奇数，则不可能将数组分割成元素和相等的两个子集*/
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }

        /*两个集合和相等，说明总数和一定是2n*/
        if (sum % 2 != 0) {
            return false;
        }

        /*有一个最大数大于总数和的一半，说明任意一个集合持有这个maxNum都无法满足条件*/
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; --j) {
                /*只要有一次为true，就一直为true,毕竟只需要返回true或者false*/
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
