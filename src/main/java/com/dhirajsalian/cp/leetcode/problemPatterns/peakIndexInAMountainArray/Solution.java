// Problem: https://leetcode.com/problems/peak-index-in-a-mountain-array/

package com.dhirajsalian.cp.leetcode.problemPatterns.peakIndexInAMountainArray;

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (end >= start) {
            int mid = (start + end) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return mid;
            else if (arr[mid] < arr[mid - 1]) {
                end = mid - 1;
            } else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
