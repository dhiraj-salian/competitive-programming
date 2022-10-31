// Problem: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

package com.dhirajsalian.cp.leetcode.problemPatterns.findKPairsWithSmallestSums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0) + a.get(1)));
        for (int i = 0; i < nums1.length; i++) {
            if (pq.size() == k && nums1[i] >= pq.peek().get(0) + pq.peek().get(1)) break;
            for (int j = 0; j < nums2.length; j++) {
                if (pq.size() == k && nums1[i] + nums2[j] >= pq.peek().get(0) + pq.peek().get(1)) break;
                pq.offer(Arrays.asList(nums1[i], nums2[j]));
                if(pq.size()>k) pq.poll();
            }
        }
        return new ArrayList<>(pq);
    }
}
