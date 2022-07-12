// Problem: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

package com.dhirajsalian.cp.leetcode.searchInRotatedSortedArray2;

class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int mid;
        while (start <= end) {
            while (start <= end && nums[start] == nums[start + 1]) start++;
            while (end >= start && nums[end] == nums[end - 1]) end--;
            mid = (start + end) / 2;
            if (nums[mid] == target) return true;
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
