// Problem: https://leetcode.com/problems/count-of-range-sum/

package com.dhirajsalian.cp.leetcode.problemPatterns.countOfRangeSum;

class Solution {

    private int count;

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] preSum = new long[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        count = 0;
        mergeSort(preSum, 0, nums.length - 1, lower, upper);
        return count;
    }

    void mergeSort(long[] nums, int start, int end, int lower, int upper) {
        if (start == end) {
            if (lower <= nums[start] && nums[start] <= upper) count++;
        }
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(nums, start, mid, lower, upper);
            mergeSort(nums, mid + 1, end, lower, upper);
            merge(nums, start, mid, mid + 1, end, lower, upper);
        }
    }

    void merge(long[] nums, int start1, int end1, int start2, int end2, int lower, int upper) {
        long[] temp = new long[end2 - start1 + 1];
        int jl = start2, jh = start2;
        for (int i = start1; i <= end1; i++) {
            while (jl <= end2 && nums[jl] - nums[i] < lower) jl++;
            while (jh <= end2 && nums[jh] - nums[i] <= upper) jh++;
            count += jh - jl;
        }
        int c1 = start1, c2 = start2;
        int c = 0;
        while (c1 <= end1 && c2 <= end2) {
            if (nums[c1] <= nums[c2]) {
                temp[c] = nums[c1];
                c1++;
            } else {
                temp[c] = nums[c2];
                c2++;
            }
            c++;
        }
        while (c1 <= end1) {
            temp[c++] = nums[c1++];
        }
        while (c2 <= end2) {
            temp[c++] = nums[c2++];
        }
        c = 0;
        for (int x = start1; x <= end2; x++, c++) {
            nums[x] = temp[c];
        }
    }

}
