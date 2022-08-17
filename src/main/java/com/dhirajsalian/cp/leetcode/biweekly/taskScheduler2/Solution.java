// Problem: https://leetcode.com/contest/biweekly-contest-84/problems/task-scheduler-ii/

package com.dhirajsalian.cp.leetcode.biweekly.taskScheduler2;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long currentDay = 0;
        int currentTaskIndex = 0;
        Map<Integer, Long> lastTaskDay = new HashMap<>();
        while (currentTaskIndex < tasks.length) {
            if (!lastTaskDay.containsKey(tasks[currentTaskIndex]) || currentDay - lastTaskDay.get(tasks[currentTaskIndex]) > space) {
                currentDay++;
                lastTaskDay.put(tasks[currentTaskIndex], currentDay);
            } else if (currentDay - lastTaskDay.get(tasks[currentTaskIndex]) <= space) {
                currentDay = lastTaskDay.get(tasks[currentTaskIndex]) + space + 1;
                lastTaskDay.put(tasks[currentTaskIndex], currentDay);
            }
            currentTaskIndex++;
        }
        return currentDay;
    }
}
