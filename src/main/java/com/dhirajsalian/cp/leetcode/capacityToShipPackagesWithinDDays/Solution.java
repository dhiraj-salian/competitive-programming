package com.dhirajsalian.cp.leetcode.capacityToShipPackagesWithinDDays;

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCapacity = weights[0], maxCapacity = weights[0];
        for (int i = 1; i < weights.length; i++) {
            minCapacity = Math.max(minCapacity, weights[i]);
            maxCapacity += weights[i];
        }
        return binarySearchOnAnswer(minCapacity, maxCapacity, weights, days);
    }

    int binarySearchOnAnswer(int minCapacity, int maxCapacity, int[] weights, int days) {
        int answer = 0;
        while (minCapacity <= maxCapacity) {
            int midCapacity = (minCapacity + maxCapacity) / 2;
            if (isPossible(midCapacity, weights, days)) {
                maxCapacity = midCapacity - 1;
                answer = midCapacity;
            } else {
                minCapacity = midCapacity + 1;
            }
        }
        return answer;
    }

    boolean isPossible(int capacity, int[] weights, int days) {
        int tempDays = 0;
        int tempCapacity = 0;
        for (int i = 0; i < weights.length; i++) {
            tempCapacity += weights[i];

            if (tempCapacity > capacity) {
                tempDays++;
                tempCapacity = weights[i];
            }

            if (tempDays > days) return false;
        }
        return ++tempDays <= days;
    }
}
