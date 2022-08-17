// Problem: https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/

package com.dhirajsalian.cp.leetcode.problemPatterns.countElementsWithStrictlySmallerAndGreaterElements;

public class Solution {
    public int countElements(int[] nums) {
        int count = 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max && nums[i] > min) count++;
        }
        return count;
    }
}
