package com.prep2023.trees.trie;

/**
 * Author: Bhupendra Shekhawat
 * Date: 27/10/23
 * Topic: com.prep2023.trees.trie
 * Question Link: https://leetcode.com/problems/implement-trie-prefix-tree/description/
 * YouTube Link: 
 * Problem: 208. Implement Trie (Prefix Tree)
 * MEDIUM
 */

class Trie {

    TrieNode head;

    public Trie(){
        this.head = new TrieNode('*');
    }
    
    public void insert(String word) {
        TrieNode curNode = head; 
        
        for(char c : word.toCharArray()){
            int index = c -'a';
            if(curNode.children[index] == null){
                curNode.children[index] = new TrieNode(c);
            }
            curNode = curNode.children[index];
        }
        curNode.isTerminal = true;

    }
    
    public boolean search(String word) {
        TrieNode curNode = head; 
        
        for(char c : word.toCharArray()){
            int index = c -'a';
            if(curNode.children[index] == null){
                return false;
            }
            curNode = curNode.children[index];
        }
        return curNode.isTerminal;   //check if this was a word
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curNode = head; 
        
        for(char c : prefix.toCharArray()){
            int index = c -'a';
            if(curNode.children[index] == null){
                return false;
            }
            curNode = curNode.children[index];
        }
        return true;
    }

    class TrieNode{
        boolean isTerminal;
        char ch;
        TrieNode[] children;

        TrieNode(char ch){
            this.ch = ch;
            this.isTerminal = false;
            this.children = new TrieNode[26];  //as for our case the candidates are lowercase english letters only
        } 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */