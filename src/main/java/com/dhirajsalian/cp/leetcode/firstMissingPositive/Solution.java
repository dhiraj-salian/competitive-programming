// Problem: https://leetcode.com/problems/first-missing-positive/

package com.dhirajsalian.cp.leetcode.firstMissingPositive;

class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) nums[i] = nums.length+1;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (index >= 0 && index < nums.length && nums[index]>0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) return i;
        }
        return nums.length+1;
    }
}
