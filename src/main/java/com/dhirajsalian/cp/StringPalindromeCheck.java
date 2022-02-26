package com.dhirajsalian.cp;

/*
Given a string, check if it is palindrome.

Examples:

Input 1: "ABCDCBA"
Output 1: yes

Input 2: "ABBA"
Output 2: yes

Input 3: "geeks"
Output 3: no

Sources: geeksforgeeks.org
 */
public class StringPalindromeCheck {

    static boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] inputs = {"ABCDCBA", "ABBA", "geeks"};
        for (String input : inputs) {
            System.out.println(isPalindrome(input) ? "yes" : "no");
        }
    }
}
