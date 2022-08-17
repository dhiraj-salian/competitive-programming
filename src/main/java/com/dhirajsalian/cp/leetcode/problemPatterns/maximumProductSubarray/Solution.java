// Problem: https://leetcode.com/problems/maximum-product-subarray/

package com.dhirajsalian.cp.leetcode.problemPatterns.maximumProductSubarray;

class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0], currentMaxProduct = nums[0], currentMinProduct = nums[0];
        int greater, smaller;
        for (int i = 1; i < nums.length; i++) {
            greater = Math.max(currentMaxProduct * nums[i], currentMinProduct * nums[i]);
            smaller = Math.min(currentMaxProduct * nums[i], currentMinProduct * nums[i]);

            currentMaxProduct = Math.max(nums[i], greater);
            currentMinProduct = Math.min(nums[i], smaller);

            maxProduct = Math.max(currentMaxProduct, maxProduct);
        }
        return maxProduct;
    }
}
