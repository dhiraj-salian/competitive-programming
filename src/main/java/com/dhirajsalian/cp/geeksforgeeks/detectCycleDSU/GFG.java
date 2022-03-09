// Problem: https://practice.geeksforgeeks.org/problems/detect-cycle-using-dsu/1

package com.dhirajsalian.cp.geeksforgeeks.detectCycleDSU;

// { Driver Code Starts

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.detectCycle(V, adj);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution {

    //Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] parent = new int[V];
        int[] rank = new int[V];
        Arrays.fill(rank, -1);
        for (int i = 0; i < V; i++) parent[i] = i;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                if (i<adj.get(i).get(j)) {
                    if (find(i, parent) == find(adj.get(i).get(j), parent)) return 1;
                    union(i, adj.get(i).get(j), parent, rank);
                }
            }
        }
        return 0;
    }

    private void union(int a, int b, int[] parent, int[] rank) {
        int aRep = find(a, parent), bRep = find(b, parent);
        if (aRep == bRep) return;
        if (rank[aRep] < rank[bRep]) parent[aRep] = bRep;
        else if (rank[bRep] < rank[aRep]) parent[bRep] = aRep;
        else {
            parent[bRep] = aRep;
            rank[aRep]++;
        }
    }

    private int find(int a, int[] parent) {
        if (a == parent[a]) return a;
        parent[a] = find(parent[a], parent);
        return parent[a];
    }
}
