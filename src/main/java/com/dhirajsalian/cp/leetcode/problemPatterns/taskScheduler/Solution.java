// Problem: https://leetcode.com/problems/task-scheduler/

package com.dhirajsalian.cp.leetcode.problemPatterns.taskScheduler;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> frequency = new HashMap<>();
        int maxFrequency = 0;
        for (char task : tasks) {
            frequency.put(task, frequency.getOrDefault(task, 0) + 1);
            maxFrequency = Math.max(maxFrequency, frequency.get(task));
        }
        int maxFrequencyTasks = 0;
        for (char task : frequency.keySet()) {
            if (frequency.get(task) == maxFrequency) maxFrequencyTasks++;
        }
        return Math.max(tasks.length, (maxFrequency - 1) * (n + 1) + maxFrequencyTasks);
    }
}