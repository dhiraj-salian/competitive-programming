// Problem: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

package com.dhirajsalian.cp.leetcode.findMinimumInRotatedSortedArray;

class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        int mid;
        if (nums[start] <= nums[end]) return nums[start];
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            else if (nums[mid] < nums[mid - 1]) return nums[mid];
            else if (nums[mid] > nums[start]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid - 1;
            }
        }
        return -1;
    }
}
