// Problem: https://leetcode.com/problems/binary-search/

package com.dhirajsalian.cp.leetcode.binarySearch;

class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (end >= start) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
