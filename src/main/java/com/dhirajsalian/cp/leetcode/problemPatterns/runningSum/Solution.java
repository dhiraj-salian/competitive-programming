// Problem: https://leetcode.com/problems/running-sum-of-1d-array/

package com.dhirajsalian.cp.leetcode.problemPatterns.runningSum;

class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
