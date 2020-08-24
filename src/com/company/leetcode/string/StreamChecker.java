package com.company.leetcode.string;

class StreamChecker {
    public static void main(String[] args) {
        String[] a = {"cd", "f", "kl"};
        StreamChecker sc = new StreamChecker(a);
        sc.query('a');
        sc.query('b');
        sc.query('c');
        System.out.println(sc.query('d'));
        sc.query('e');
    }

    class TrieNode {
        boolean isWord = false;
        TrieNode[] next = new TrieNode[26];
    }

    StringBuilder sb = new StringBuilder();
    TrieNode root = new TrieNode();

    public StreamChecker(String[] words) {
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

    }

    public void insert(String s) {
        TrieNode node = root;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        node.isWord = true;
    }

    public boolean query(char letter) {
        TrieNode node = root;
        sb.append(letter);
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (node.isWord) {
                return true;
            }
            if (node.next[c - 'a'] != null) {
                node = node.next[c - 'a'];
            } else {
                return false;
            }
        }
        return false;
    }
}

