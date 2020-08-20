package com.company.leetcode.trie;

import java.util.PropertyResourceBundle;

public class AddAndSearchWord {
    public static void main(String[] args) {
        AddAndSearchWord addAndSearchWord = new AddAndSearchWord();
        addAndSearchWord.addWord("a");
        System.out.println("false: " + addAndSearchWord.search("a."));
        addAndSearchWord.addWord("bad");
        addAndSearchWord.addWord("dad");
        addAndSearchWord.addWord("mad");
        System.out.println("true: " + addAndSearchWord.search("b.."));
        System.out.println("false: " + addAndSearchWord.search("pad"));
        System.out.println("true: " + addAndSearchWord.search("bad"));
        System.out.println("true: " + addAndSearchWord.search(".ad"));

    }

    /**
     * Initialize your data structure here.
     */

    public AddAndSearchWord() {

    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        this.insert(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return this.search2(word);
    }

    /**
     * Initialize your data structure here.
     */
    public static class TrieNode {
        TrieNode[] chars = new TrieNode[26];
        int count = 0;
    }

    TrieNode root = null;


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
    public boolean search2(String word) {
        if (word.length() == 0) return true;
        if (root == null) return false;
        return search2(word, root, 0);
    }

    private boolean search2(String word, TrieNode root, int i) {
        if (word.charAt(i) == '.') {
            if (word.length() - 1 == i) {
                for (int j = 0; j < 26; j++) {
                    if (root.chars[j] != null && i < word.length()) {
                        if (root.chars[j].count > 0) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                boolean result = false;
                for (int j = 0; j < 26; j++) {
                    if (root.chars[j] != null && i + 1 < word.length()) {
                        result = search2(word, root.chars[j], i + 1);
                    }
                    if (result) return true;
                }
            }
            return false;
        }
        int index = word.charAt(i) - 'a';
        if (root.chars[index] == null) return false;
        if (word.length() - 1 == i && root.chars[index].count > 0) return true;
        if (word.length() - 1 == i) return false;
        return search2(word, root.chars[index], i + 1);
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
