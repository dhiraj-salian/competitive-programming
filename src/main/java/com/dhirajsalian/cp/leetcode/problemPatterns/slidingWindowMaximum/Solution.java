// Problem: https://leetcode.com/problems/sliding-window-maximum/

package com.dhirajsalian.cp.leetcode.problemPatterns.slidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int start = 0, end = 0;
        while (end < nums.length) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[end]) {
                deque.removeLast();
            }
            deque.addLast(end);
            if (start > deque.getFirst()) deque.removeFirst();
            if (end - start + 1 == k) {
                result[start] = nums[deque.getFirst()];
                start++;
            }
            end++;
        }
        return result;
    }
}
