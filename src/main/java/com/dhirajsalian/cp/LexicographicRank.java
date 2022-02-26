package com.dhirajsalian.cp;

/*
Given a string str, find the lexicographic rank of the string.

Examples:

Input 1: str = "BAC"
Output 1: 3

Input 2: str = "CBA"
Output 2: 6

Input 3: str = "DCBA"
Output 3: 24

Input 4: str = "STRING"
Output 4: 598

Source: geeksforgeeks.org
 */
public class LexicographicRank {

    static int lexicographicRank(String str) {
        int res = 1;
        int n = str.length();
        int mult = fact(n);
        int[] count = new int[256];
        for (int i = 0; i < n; i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < n - 1; i++) {
            mult = mult / (n - i);
            res += count[str.charAt(i)-1] * mult;
            for (int j = str.charAt(i); j < 256; j++) {
                count[j]--;
            }
        }
        return res;
    }

    static int fact(int n) {
        if (n == 0) return 1;
        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        String[] inputStr = {"BAC", "CBA", "DCBA", "STRING"};
        for (String str : inputStr) {
            System.out.println(lexicographicRank(str));
        }
    }
}
