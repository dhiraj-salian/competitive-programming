package com.dhirajsalian.cp.util;

import java.util.ArrayList;

public class CustomUtil {

    public static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void print(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void print(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void swap(int[][] m, int i1, int j1, int i2, int j2) {
        int temp = m[i1][j1];
        m[i1][j1] = m[i2][j2];
        m[i2][j2] = temp;
    }

    public static void printLinkedList(LLNode head) {
        while (head != null) {
            System.out.printf("%s->", head.value);
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static LLNode createLinkedList(int[] arr) {
        LLNode next = null, curr = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            curr = new LLNode(arr[i], next);
            next = curr;
        }
        return curr;
    }

    public static void addUndirectedEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void addDirectedEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
    }

    public static void addDirectedWeightedEdge(ArrayList<ArrayList<GraphWeightedNode>> graph, int u, int v, int weight) {
        graph.get(u).add(new GraphWeightedNode(v, weight));
    }

    public static String yesOrNo(boolean value) {
        return value ? "Yes" : "No";
    }
}
