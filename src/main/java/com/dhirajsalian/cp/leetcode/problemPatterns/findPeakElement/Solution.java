// Problem: https://leetcode.com/problems/find-peak-element/

package com.dhirajsalian.cp.leetcode.problemPatterns.findPeakElement;

class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1])
                    && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) return mid;
            if (mid != 0 && nums[mid] < nums[mid - 1]) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
}
