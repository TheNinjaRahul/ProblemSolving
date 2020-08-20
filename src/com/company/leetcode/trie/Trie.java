package com.company.leetcode.trie;

public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("true: " + trie.search("apple"));
        System.out.println("false: " + trie.search("app"));
        System.out.println("true: " + trie.startsWith("app"));
        trie.insert("app");
        System.out.println("true: " + trie.search("app"));
    }

    /**
     * Initialize your data structure here.
     */
    public static class TrieNode {
        TrieNode[] chars = new TrieNode[26];
        int count = 0;
    }

    TrieNode root = null;

    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (root == null) {
            root = new TrieNode();
        }
        insert(word, root, 0);
    }

    private void insert(String word, TrieNode root, int i) {
        int index = word.charAt(i) - 'a';
        if (root.chars[index] == null) {
            root.chars[index] = new TrieNode();
        }
        if (word.length() - 1 == i) {
            root.chars[index].count += 1;
        } else {
            insert(word, root.chars[index], i + 1);
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word.length() == 0) return true;
        if (root == null) return false;
        return search(word, root, 0);
    }

    private boolean search(String word, TrieNode root, int i) {
        int index = word.charAt(i) - 'a';
        if (root.chars[index] == null) return false;
        if (word.length() - 1 == i && root.chars[index].count > 0) return true;
        if (word.length() - 1 == i) return false;
        return search(word, root.chars[index], i + 1);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0) return true;
        if (root == null) return false;
        return startsWith(prefix, root, 0);
    }

    private boolean startsWith(String prefix, TrieNode root, int i) {
        int index = prefix.charAt(i) - 'a';
        if (root.chars[index] == null) return false;
        if (prefix.length() - 1 == i) return true;
        return startsWith(prefix, root.chars[index], i + 1);
    }
}
