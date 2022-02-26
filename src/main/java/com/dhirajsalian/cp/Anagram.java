package com.dhirajsalian.cp;

/*
Given two strings, check if they are anagrams.
Same number of characters but order can be different.

Examples:

Input 1: s1 = "silent", s2 = "listen"
Output 1: yes

Input 2: s1 = "aaacb", s2 = "cabaa"
Output 2: yes

Input 3: s1 = "aab", s2 = "bab"
Output 3: no

Source: geekforgeeks.org
 */
public class Anagram {

    static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] alphabets = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            alphabets[s1.charAt(i) - 'a']++;
            alphabets[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (alphabets[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] inputS1 = {"silent", "aaacb", "aab"};
        String[] inputS2 = {"listen", "cabaa", "bab"};
        for (int i = 0; i < inputS1.length; i++) {
            System.out.println(isAnagram(inputS1[i], inputS2[i]) ? "yes" : "no");
        }
    }
}
