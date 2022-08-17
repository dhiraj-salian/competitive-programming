// Problem: https://leetcode.com/problems/minimum-size-subarray-sum/

package com.dhirajsalian.cp.leetcode.problemPatterns.minimumSizeSubarraySum;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, sum = 0, res = nums.length+1;
        while (end < nums.length) {
            sum += nums[end];
            while (start <= end && sum >= target) {
                res = Math.min(res, end - start+1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return res==nums.length+1 ? 0 : res;
    }
}
