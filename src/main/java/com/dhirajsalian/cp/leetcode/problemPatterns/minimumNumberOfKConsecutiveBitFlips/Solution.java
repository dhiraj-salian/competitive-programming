// Problem: https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/

package com.dhirajsalian.cp.leetcode.problemPatterns.minimumNumberOfKConsecutiveBitFlips;

class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int start = 0, end = 0, flips = 0, res = 0, lastFlip = -1;
        while (end < nums.length) {
            if (nums[end] == flips % 2) {
                flips++;
                lastFlip = end;
                res++;
                nums[end] = -1;
            }
            if (end - start + 1 >= k) {
                if (nums[start] < 0) flips--;
                start++;
            }
            end++;
        }
        return nums.length - k >= lastFlip ? res : -1;
    }
}
