// Problem: https://leetcode.com/problems/median-of-two-sorted-arrays/

package com.dhirajsalian.cp.leetcode.medianOfTwoSortedArrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = m + n;

        int low = 0;
        int high = m;

        double result = 0.0;

        while (low <= high) {
            // nums1
            int i = low + (high - low) / 2;
            // nums2
            int j = (total + 1) / 2 - i;

            int left1 = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
            int right1 = (i < m) ? nums1[i] : Integer.MAX_VALUE;
            int left2 = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
            int right2 = (j < n) ? nums2[j] : Integer.MAX_VALUE;

            // partition is correct
            if (left1 <= right2 && left2 <= right1) {
                // even
                if (total % 2 == 0) {
                    result = (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                    // odd
                } else {
                    result = Math.max(left1, left2);
                }
                break;
            } else if (left1 > right2) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }

        return result;
    }
}
