package com.dhirajsalian.cp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/*
Given two unsorted arrays, print the count of intersection elements of the two arrays.

Examples:

Input 1: a = [ 10, 15, 20, 5, 30 ]
         b = [ 30, 5, 30 ,8 ]
Output 1: 2

Input 2: a = [ 10, 20 ]
         b = [ 20, 30 ]
Output 2: 1

Input 3: a = [ 10, 10, 10 ]
         b = [ 10, 10, 10 ]
Output 3: 1

Source: geeksforgeeks.org
 */
public class IntersectionUnsortedArrays {

    static int intersectionCount(int[] a, int[] b) {
        int count = 0;
        HashSet<Integer> h = Arrays.stream(a).boxed().collect(Collectors.toCollection(HashSet::new));
        for (int num : b) {
            if (h.contains(num)) {
                count++;
                h.remove(num);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] inputA = {{10, 15, 20, 5, 30}, {10, 20}, {10, 10, 10}};
        int[][] inputB = {{30, 5, 30, 8}, {20, 30}, {10, 10, 10}};
        for (int i = 0; i < inputA.length; i++) {
            System.out.println(intersectionCount(inputA[i], inputB[i]));
        }
    }
}
