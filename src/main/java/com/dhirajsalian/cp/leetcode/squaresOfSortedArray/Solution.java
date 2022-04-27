// Problem: https://leetcode.com/problems/squares-of-a-sorted-array/

package com.dhirajsalian.cp.leetcode.squaresOfSortedArray;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int negativeStart = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                negativeStart = i;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        if (negativeStart == -1)
            return nums;
        int positiveStart = negativeStart + 1;
        int index = 0;
        while (negativeStart >= 0 && positiveStart < nums.length) {
            if(nums[negativeStart]<=nums[positiveStart]) {
                ans[index] = nums[negativeStart];
                negativeStart--;
            } else {
                ans[index]=nums[positiveStart];
                positiveStart++;
            }
            index++;
        }
        while(positiveStart<nums.length) {
            ans[index]=nums[positiveStart];
            index++;
            positiveStart++;
        }
        while(negativeStart>=0) {
            ans[index]=nums[negativeStart];
            index++;
            negativeStart--;
        }
        return ans;
    }
}
