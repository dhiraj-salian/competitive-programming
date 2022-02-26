package com.dhirajsalian.cp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/*
Given two unsorted arrays, return the count of union of two arrays.

Examples:

Input 1: a = [ 15, 20, 5, 15 ]
         b = [ 15, 15, 15, 20, 10 ]
Output 1: 4

Input 2: a = [ 10, 12, 15 ]
         b = [ 18, 12 ]
Output 2: 4

Input 3: a = [ 3, 3, 3 ]
         b = [ 3, 3 ]
Output 3: 1

Source: geeksforgeeks.org
 */
public class UnionUnsortedArrays {

    static int unionCount(int[] a, int[] b) {
        HashSet<Integer> h = new HashSet<>();
        h.addAll(Arrays.stream(a).boxed().collect(Collectors.toList()));
        h.addAll(Arrays.stream(b).boxed().collect(Collectors.toList()));
        return h.size();
    }

    public static void main(String[] args) {
        int[][] inputA = {{15, 20, 5, 15}, {10, 12, 15}, {3, 3, 3}};
        int[][] inputB = {{15, 15, 15, 20, 10}, {18, 12}, {3, 3}};
        for (int i = 0; i < inputA.length; i++) {
            System.out.println(unionCount(inputA[i], inputB[i]));
        }
    }
}
