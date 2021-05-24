package com.yuyisummer.leetcode.editor.cn;

//有台奇怪的打印机有以下两个特殊要求：
//
// 
// 打印机每次只能打印由 同一个字符 组成的序列。 
// 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。 
// 
//
// 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabbb"
//输出：2
//解释：首先打印 "aaa" 然后打印 "bbb"。
// 
//
// 示例 2： 
//
// 
//输入：s = "aba"
//输出：2
//解释：首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 122 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {


    public int strangePrinter(String s) {
        int n = s.length();
        /*记录状态*/
        int[][] f = new int[n][n];
        /*需要知道对应的状态转移方程*/
        /*反向遍历字符串S*/
        for (int i = n - 1; i >= 0; i--) {
            /*边界条件为1*/
            f[i][i] = 1;
            /*当前位置到最后内容遍历*/
            for (int j = i + 1; j < n; j++) {
                /*某个表达式，能够通过二维数组矩阵得到对应的结果*/
                if (s.charAt(i) == s.charAt(j)) {
                    /*变更数据*/
                    f[i][j] = f[i][j - 1];
                } else {
                    int minn = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {

                        minn = Math.min(minn, f[i][k] + f[k + 1][j]);
                    }
                    f[i][j] = minn;
                }
            }
        }
        return f[0][n - 1];
    }
}

//leetcode submit region end(Prohibit modification and deletion)
