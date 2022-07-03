// Problem: https://leetcode.com/problems/find-smallest-letter-greater-than-target/

package com.dhirajsalian.cp.leetcode.findSmallestLetterGreaterThanTarget;

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length - 1;
        char ans = letters[0];
        while (end >= start) {
            int mid = (start + end) / 2;
            if (letters[mid] > target) {
                ans = letters[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}