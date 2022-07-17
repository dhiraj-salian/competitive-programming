// Problem: https://leetcode.com/problems/find-k-closest-elements/

package com.dhirajsalian.cp.leetcode.findKClosestElements;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0, end = arr.length - k;
        List<Integer> result = new ArrayList<>();
        while (start < end) {
            int mid = (start + end) / 2;
            if (x - arr[mid] > arr[mid + k] - x) start = mid + 1;
            else end = mid;
        }
        for (int i = start; i < end + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
