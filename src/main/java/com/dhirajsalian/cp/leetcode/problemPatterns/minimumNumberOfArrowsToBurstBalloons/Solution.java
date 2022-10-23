// Problem: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

package com.dhirajsalian.cp.leetcode.problemPatterns.minimumNumberOfArrowsToBurstBalloons;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int arrows = 1;
        int reach = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > reach) {
                arrows++;
                reach = points[i][1];
            }
        }
        return arrows;
    }
}