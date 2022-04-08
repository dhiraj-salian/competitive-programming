// Problem: https://leetcode.com/problems/single-number/

package com.dhirajsalian.cp.leetcode.singleNumber;

class Solution {
    public int singleNumber(int[] nums) {
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++)
            xor ^= nums[i];
        return xor;
    }
}
