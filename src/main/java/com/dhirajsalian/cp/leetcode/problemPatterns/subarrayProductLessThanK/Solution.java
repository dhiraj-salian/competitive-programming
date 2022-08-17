// Problem: https://leetcode.com/problems/subarray-product-less-than-k/

package com.dhirajsalian.cp.leetcode.problemPatterns.subarrayProductLessThanK;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0, end = 0;
        long product = 1;
        int count = 0;
        while(end < nums.length) {
            product *= nums[end];
            while(start<=end && product >= k) {
                product/=nums[start];
                start++;
            }
            count += end - start + 1;
            end++;
        }
        return count;
    }
}
