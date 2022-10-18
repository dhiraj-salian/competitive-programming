// Problem: https://leetcode.com/problems/maximum-frequency-stack/

package com.dhirajsalian.cp.leetcode.problemPatterns.maximumFrequencyStack;

import java.util.HashMap;
import java.util.Stack;

class FreqStack {

    private HashMap<Integer, Stack<Integer>> frequencyOrder;
    private HashMap<Integer, Integer> frequency;
    int maxFrequency;

    public FreqStack() {
        frequencyOrder = new HashMap<>();
        frequency = new HashMap<>();
        maxFrequency = 0;
    }

    public void push(int val) {
        if (!frequency.containsKey(val)) {
            frequency.put(val, 1);
        } else {
            frequency.put(val, frequency.get(val) + 1);
        }
        maxFrequency = Math.max(maxFrequency, frequency.get(val));
        if (!frequencyOrder.containsKey(frequency.get(val)))
            frequencyOrder.put(frequency.get(val), new Stack<>());
        frequencyOrder.get(frequency.get(val)).push(val);
    }

    public int pop() {
        if (maxFrequency == 0 || frequency.isEmpty())
            throw new IllegalStateException("Pop is invalid");
        int val = frequencyOrder.get(maxFrequency).pop();
        frequency.put(val, frequency.get(val) - 1);
        if (frequency.get(val) == 0) frequency.remove(val);
        if (frequencyOrder.get(maxFrequency).isEmpty()) {
            frequencyOrder.remove(maxFrequency);
            maxFrequency--;
        }
        return val;
    }
}
