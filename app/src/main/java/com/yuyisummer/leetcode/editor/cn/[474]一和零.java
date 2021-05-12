//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。 
//
// 
// 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。 
//
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//输出：4
//解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 
//n 的值 3 。
// 
//
// 示例 2： 
//
// 
//输入：strs = ["10", "0", "1"], m = 1, n = 1
//输出：2
//解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 600 
// 1 <= strs[i].length <= 100 
// strs[i] 仅由 '0' 和 '1' 组成 
// 1 <= m, n <= 100 
// 
// Related Topics 动态规划 
// 👍 390 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static void main(String[] args) {

        String[] data = new String[]{"10", "00010000", "111001", "1", "0"};

        new Solution().findMaxForm(data, 5, 3);
    }


    /**
     * @param strs 二进制字符串数组 expr:["10", "0001", "111001", "1", "0"]
     * @param m    最多有m个0 expr:5
     * @param n    最多有n个1 expr:#
     * @return 满足条件的子集数量
     */
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            int[] count = countzeroesones(s);
            /*从大到小遍历，避免出现脏数据*/
            for (int zeroes = m; zeroes >= count[0]; zeroes--) {
                for (int ones = n; ones >= count[1]; ones--) {
                    /*状态转移公式*/
                    dp[zeroes][ones] = Math.max(
                            1 + dp[zeroes - count[0]][ones - count[1]],
                            dp[zeroes][ones]);
                }
            }


        }
        return dp[m][n];
    }

    /*判断传入字符串，0和1各有多少，存入int数组后返回，进行了一定的优化*/
    public int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - '0']++;
        }
        return c;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
