package com.prep2023.trees.trie;

/**
 * Author: Bhupendra Shekhawat
 * Date: 27/10/23
 * Topic: com.prep2023.trees.trie
 * Question : <a href="https://leetcode.com/problems/implement-trie-ii-prefix-tree/description/">1804. Implement Trie II (Prefix Tree)</a>
 * YouTube : <a href="">Link to YouTube</a>
 * Problem: 
 */

class Trie_II {

    TrieNode head;
    public Trie_II() {
        head = new TrieNode('*');
    }

    public void insert(String word) {
        TrieNode cur = head;
        for(char c : word.toCharArray()){
            int index = c -'a';
            if(cur.children[index] == null){
                TrieNode newNode = new TrieNode(c);
                cur.children[index] = newNode;
            }
            cur.children[index].prefixCount += 1;
            cur = cur.children[index];
        }
        cur.wordCount += 1;
    }

    public int countWordsEqualTo(String word) {
        TrieNode cur = head;
        int count = 0;
        for(char c : word.toCharArray()){
            int index = c-'a';
            if(cur.children[index] == null){
                return 0;
            }
            cur = cur.children[index];
        }
        return cur.wordCount;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode cur = head;
        int count = 0;
        for(char c : prefix.toCharArray()){
            int index = c-'a';
            if(cur.children[index] == null){
                return 0;
            }
            cur = cur.children[index];
        }
        return cur.prefixCount;
    }

    public void erase(String word) {
        //It is guaranteed that for any function call to erase, the string word will exist in the trie.
        TrieNode cur = head;
        for(char c : word.toCharArray()){
            int index = c-'a';
            cur.children[index].prefixCount -= 1;
            cur = cur.children[index];
        }
        cur.wordCount -= 1;
    }

    class TrieNode{
        char val;
        TrieNode children[];
        int wordCount;
        int prefixCount;

        TrieNode(char val){
            this.val = val;
            this.wordCount = 0;
            this.prefixCount = 0;
            this.children = new TrieNode[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */