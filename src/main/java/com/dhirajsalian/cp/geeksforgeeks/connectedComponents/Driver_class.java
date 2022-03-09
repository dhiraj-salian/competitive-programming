// Problem: https://practice.geeksforgeeks.org/problems/number-of-connected-components/0

package com.dhirajsalian.cp.geeksforgeeks.connectedComponents;

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;

class Driver_class {
    static int arr[] = new int[100001];
    static int rank1[] = new int[100001];

    public static void main(String args[]) throws IOException {
        //taking input using BufferedReader
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        //taking total testcases
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            //taking count of total nodes
            int n = Integer.parseInt(read.readLine());

            //initializing parent array and
            //rank array
            for (int i = 1; i <= n; i++) {
                arr[i] = i;
                rank1[i] = 1;
            }

            //taking number of queries
            int q = Integer.parseInt(read.readLine());

            //creating an object of
            //class Solution
            Solution obj = new Solution();
            while (q-- > 0) {
                String str[] = read.readLine().trim().split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);

                //calling unionNodes() method of
                //class Connected
                obj.unionNodes(a, b, arr, rank1, n);
            }

            //calling method findNumberofConnectedComponents()
            //of class Solution
            System.out.println(obj.findNumberOfConnectedComponents(n, arr, rank1));
        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution {

    //Function to merge two nodes a and b.
    static void unionNodes(int a, int b, int arr[], int rank1[], int n) {
        int aRep = find(a, arr), bRep = find(b, arr);
        if (aRep == bRep) return;
        if (rank1[aRep] < rank1[bRep]) arr[aRep] = bRep;
        else if (rank1[bRep] < rank1[aRep]) arr[bRep] = aRep;
        else {
            arr[bRep] = aRep;
            rank1[aRep]++;
        }
    }

    //Function to determine number of connected components.
    static int findNumberOfConnectedComponents(int n, int arr[], int rank1[]) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i] == i) count++;
        }
        return count;
    }

    static int find(int a, int arr[]) {
        if (a == arr[a]) return a;
        arr[a] = find(arr[a], arr);
        return arr[a];
    }
}
