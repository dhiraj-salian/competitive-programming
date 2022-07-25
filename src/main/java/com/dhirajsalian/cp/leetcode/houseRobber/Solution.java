// Problem: https://leetcode.com/problems/house-robber/

package com.dhirajsalian.cp.leetcode.houseRobber;

class Solution {
    public int rob(int[] nums) {
        int[] theft = new int[nums.length + 1];
        theft[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            theft[i] = Math.max(nums[i - 1] + (i - 2 < 0 ? 0 : theft[i - 2]), theft[i - 1]);
        }
        return theft[nums.length];
    }

    /*

    Recursive Solution

    int rob(int[] nums, int n) {
        if (n == 0) return 0;
        return Math.max(nums[n - 1] + rob(nums, n - 2), rob(nums, n - 1));
    }

    */

}
