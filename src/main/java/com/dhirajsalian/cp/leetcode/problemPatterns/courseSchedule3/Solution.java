// Problem: https://leetcode.com/problems/course-schedule-iii/

package com.dhirajsalian.cp.leetcode.problemPatterns.courseSchedule3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(c -> c[1]));
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            heap.add(course[0]);
            if (time > course[1]) time -= heap.poll();
        }
        return heap.size();
    }
}
