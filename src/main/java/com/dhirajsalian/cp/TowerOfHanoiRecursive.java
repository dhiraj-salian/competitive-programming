package com.dhirajsalian.cp;

/*
Tower Of Hanoi
Rules:
1. Only 1 disc moves at a time.
2. No larger disc above smaller.
3. Only top disc of a tower can be moved.

Examples:

Input 1: n = 1
Output 1: Move Disc 1 from A to C

Input 2: n = 2
Output 2: Move Disc 1 from A to B
          Move Disc 2 from A to C
          Move Disc 1 from B to C

Input 3: n = 3
Output 3: Move Disc 1 from A to C
          Move Disc 2 from A to B
          Move Disc 1 from C to B
          Move Disc 3 from A to C
          Move Disc 1 from B to A
          Move Disc 2 from B to C
          Move Disc 1 from A to C

Source: geeksforgeeks.org
 */
public class TowerOfHanoiRecursive {

    static void towerOfHanoi(int n, char a, char b, char c) {
        if (n == 0) return;
        towerOfHanoi(n - 1, a, c, b);
        System.out.printf("Move Disc %d from %s to %s\n", n, a, c);
        towerOfHanoi(n - 1, b, a, c);
    }

    public static void main(String[] args) {
        int[] inputs = {1, 2, 3};
        for (int input : inputs) {
            towerOfHanoi(input, 'A', 'B', 'C');
            System.out.println();
        }
    }
}
