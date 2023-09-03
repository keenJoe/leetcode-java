package org.xqd.learning.leetcode.dp2;


/**
 * 55. Jump Game
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length - 1; i++) {
            dp[length - 1][i] = true;
        }

        for (int start = 0; start < length; start++) {
            int rest = length - start - 1;

            int steps = nums[start];
            //至少走一步
            boolean can = false;
            for (int i = 1; i <= steps; i++) {

            }

            dp[start][rest] = can;
        }

        return dp[0][length - 1];
    }


    public boolean canJump1(int[] nums) {
        int start = 0;
        int end = nums.length;

        return f(0, end - 1, nums);
    }

    private boolean f(int start, int rest, int[] nums) {
        if (start >= nums.length - 1) {
            return true;
        }

        int steps = nums[start];
        //至少走一步
        boolean can = false;
        for (int i = 1; i <= steps; i++) {
            boolean temp = f(start + i, rest - 1, nums);
            can = can || temp;
        }

        return can;
    }
}
