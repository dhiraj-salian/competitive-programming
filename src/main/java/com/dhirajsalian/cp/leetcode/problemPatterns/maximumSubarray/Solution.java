// Problem: https://leetcode.com/problems/maximum-subarray/

package com.dhirajsalian.cp.leetcode.problemPatterns.maximumSubarray;

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, answer = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            answer = Math.max(answer, sum);
        }
        return answer;
    }
}
