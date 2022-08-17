// Problem: https://leetcode.com/problems/house-robber-ii/

package com.dhirajsalian.cp.leetcode.problemPatterns.houseRobber2;

class Solution {

    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int start, int end) {
        int theft1 = 0, theft2 = nums[start], temp;
        for (int i = start; i <= end; i++) {
            temp = Math.max(nums[i] + theft1, theft2);
            theft1 = theft2;
            theft2 = temp;
        }
        return theft2;
    }

    /*
    public int rob(int[] nums, int n) {
        if (n == 0) return 0;
        return Math.max(nums[n - 1] + rob(nums, n - 2), rob(nums, n - 1));
    }
     */
}
