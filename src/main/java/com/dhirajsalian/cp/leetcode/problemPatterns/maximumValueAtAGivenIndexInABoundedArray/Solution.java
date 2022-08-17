// Problem: https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/

package com.dhirajsalian.cp.leetcode.problemPatterns.maximumValueAtAGivenIndexInABoundedArray;

class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int ans = 0;
        int left = 1, right = maxSum;
        int rSize = n - index - 1, lSize = index;
        while (left <= right) {
            int middle = (left + right) / 2;
            int m = middle - 1;
            long sum = middle;
            if (lSize <= m) {
                sum += sum(m) - sum(m - lSize);
            } else {
                sum += sum(m) + (lSize - m);
            }
            if (rSize <= m) {
                sum += sum(m) - sum(m - rSize);
            } else {
                sum += sum(m) + (rSize - m);
            }
            if (sum <= maxSum) {
                left = middle + 1;
                ans = middle;
            } else {
                right = middle - 1;
            }
        }
        return ans;
    }

    long sum(long val) {
        return val * (val + 1) / 2;
    }
}
