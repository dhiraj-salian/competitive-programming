// Problem: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

package com.dhirajsalian.cp.leetcode.problemPatterns.kthSmallestElementInSortedMatrix;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n - 1][n - 1];
        while (start < end) {
            int mid = (start + end) / 2;
            int rank = getRank(matrix, n, mid);
            if (rank >= k) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    int getRank(int[][] matrix, int n, int mid) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] <= mid) count++;
                else break;
            }
        }
        return count;
    }

    /*
        Max Heap :

        public int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            int colSize = matrix.length, rowSize = matrix[0].length;
            for (int i = 0; i < colSize; i++) {
                for (int j = 0; j < rowSize; j++) {
                    pq.offer(matrix[i][j]);
                    if (pq.size() > k) pq.poll();
                }
            }
            return pq.peek();
        }

     */
}
