// Problem: https://leetcode.com/problems/fruit-into-baskets/

package com.dhirajsalian.cp.leetcode.problemPatterns.fruitIntoBaskets;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        int start = 0, end = 0, sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (end < fruits.length) {
            sum++;
            map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);
            while (start <= end && map.size() > 2) {
                sum--;
                if (map.get(fruits[start]) == 1) map.remove(fruits[start]);
                else map.put(fruits[start], map.get(fruits[start]) - 1);
                start++;
            }
            if (map.size() <= 2) {
                res = Math.max(res, sum);
            }
            end++;
        }
        return res;
    }
}
