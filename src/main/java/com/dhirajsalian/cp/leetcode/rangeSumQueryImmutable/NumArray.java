// Problem: https://leetcode.com/problems/range-sum-query-immutable/

package com.dhirajsalian.cp.leetcode.rangeSumQueryImmutable;

class NumArray {

    int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right] - (left == 0 ? 0 : prefixSum[left - 1]);
    }
}
