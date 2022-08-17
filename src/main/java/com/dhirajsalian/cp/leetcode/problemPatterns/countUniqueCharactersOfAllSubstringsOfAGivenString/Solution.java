// Problem: https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/

package com.dhirajsalian.cp.leetcode.problemPatterns.countUniqueCharactersOfAllSubstringsOfAGivenString;


class Solution {
    public int uniqueLetterString(String s) {
        int res = 0;
        int[] lastPosition = new int[26];
        int[] contribution = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A';
            contribution[c] = i + 1 - lastPosition[c];
            res += getSum(contribution);
            lastPosition[c] = i + 1;
        }
        return res;
    }

    int getSum(int[] arr) {
        int sum = 0;
        for(int i=0;i<arr.length;i++) {
            sum+=arr[i];
        }
        return sum;
    }
}
