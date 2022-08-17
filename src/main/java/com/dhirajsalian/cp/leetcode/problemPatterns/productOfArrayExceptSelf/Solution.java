// Problem: https://leetcode.com/problems/product-of-array-except-self/

package com.dhirajsalian.cp.leetcode.problemPatterns.productOfArrayExceptSelf;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            answer[i] = nums[i] * answer[i - 1];
        }
        int suffixSum = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            answer[i] = answer[i - 1] * suffixSum;
            suffixSum *= nums[i];
        }
        answer[0]=suffixSum;
        return answer;
    }
}
