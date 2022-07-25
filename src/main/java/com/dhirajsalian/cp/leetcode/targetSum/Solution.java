// Problem: https://leetcode.com/problems/target-sum/

package com.dhirajsalian.cp.leetcode.targetSum;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) sum += nums[i];
        int absTarget = (target > 0 ? target : -target);
        int newTarget = absTarget + 2 * sum;
        int[][] targetSumWays = new int[n + 1][newTarget + 1];
        targetSumWays[0][sum] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= newTarget; j++) {
                targetSumWays[i][j] = (j - nums[i - 1] < 0 ? 0 : targetSumWays[i - 1][j - nums[i - 1]])
                        + (j + nums[i - 1] > newTarget ? 0 : targetSumWays[i - 1][j + nums[i - 1]]);
            }
        }
        return targetSumWays[n][sum + absTarget];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
    }
}
