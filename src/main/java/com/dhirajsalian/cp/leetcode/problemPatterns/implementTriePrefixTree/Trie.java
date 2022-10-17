// Problem: https://leetcode.com/problems/implement-trie-prefix-tree/

package com.dhirajsalian.cp.leetcode.problemPatterns.implementTriePrefixTree;

class TrieNode {
    TrieNode[] children;
    boolean end;

    public TrieNode() {
        children = new TrieNode[26];
        end = false;
    }

}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        if (word == null || word.isEmpty()) return;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                curr.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.end = true;
    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()) return false;
        TrieNode curr = searchForPrefix(word);
        return curr != null && curr.end;
    }

    private TrieNode searchForPrefix(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null) return null;
            else curr = curr.children[word.charAt(i) - 'a'];
        }
        return curr;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) return false;
        TrieNode curr = searchForPrefix(prefix);
        return curr != null;
    }
}