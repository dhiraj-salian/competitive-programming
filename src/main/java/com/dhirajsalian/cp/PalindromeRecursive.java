package com.dhirajsalian.cp;

/*
Given a string s, check if it is palindrome or not.

Examples:

Input 1: s = abbcbba
Output 1: yes

Input 2: s = abba
Output 2: yes

Input 3: geeks
Output 3: no

Source: geeksforgeeks.org
 */
public class PalindromeRecursive {

    static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        return isPalindrome(s, 0, s.length() - 1);
    }

    static boolean isPalindrome(String s, int start, int last) {
        if (start >= last) return true;
        if (s.charAt(start) != s.charAt(last)) return false;
        return isPalindrome(s, start + 1, last - 1);
    }

    public static void main(String[] args) {
        String[] inputs = {"abbcbba", "abba", "geeks"};
        for (String str : inputs) {
            System.out.println(isPalindrome(str) ? "yes" : "no");
        }
    }
}
