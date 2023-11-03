package com.prep2023.trees.trie;

/**
 * Author: Bhupendra Shekhawat
 * Date: 03/11/23
 * Topic: com.prep2023.trees.trie
 * Question : <a href="https://leetcode.com/problems/design-add-and-search-words-data-structure/description/">211. Design Add and Search Words Data Structure</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode('*');
    }

    public void addWord(String word) {
        if (word == null || word.isEmpty()) return;

        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.neighbors[c - 'a'] == null) {
                cur.neighbors[c - 'a'] = new TrieNode(c);
            }
            cur = cur.neighbors[c - 'a'];
        }
        cur.isTerminal = true;
    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()) return false;

        TrieNode cur = root;
        boolean result = search(word, cur);
        return result;
    }

    private boolean search(String word, TrieNode curRoot) {
        TrieNode cur = curRoot;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode nbr : cur.neighbors) {
                    //if any neighbors line matches
                    if (nbr != null && search(word.substring(i + 1), nbr)) return true;
                }
                return false;
            } else {
                if (cur.neighbors[c - 'a'] == null) return false;
                cur = cur.neighbors[c - 'a'];
            }
        }
        return cur.isTerminal;
    }


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // return False
        wordDictionary.search("bad"); // return True
        wordDictionary.search(".ad"); // return True
        wordDictionary.search("b.."); // return True
    }

    class TrieNode {
        char c;
        boolean isTerminal;
        TrieNode[] neighbors;

        TrieNode(char c) {
            this.c = c;
            this.isTerminal = false;
            this.neighbors = new TrieNode[26];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
