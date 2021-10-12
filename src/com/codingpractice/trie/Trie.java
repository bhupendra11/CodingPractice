package com.codingpractice.trie;

import java.util.HashMap;

public class Trie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private final TrieNode root;
	/*Initializes new Trie node */
	public Trie() {
		root = new TrieNode();
	}
	
	
	
	
	public class TrieNode{
		HashMap<Character, TrieNode> children;
		boolean isEndOfWord; 	
		
		public TrieNode() {
			children = new HashMap<>();
			isEndOfWord = false;
		}
	}
	
	/**
	 * Iterative implementation of insert in Trie
	 */
	public void insert(String word) {
		TrieNode current = root;
		
		for(int i=0 ;i< word.length() ;i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if(node==null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.isEndOfWord=true;
	}
	
	/**
	 * Iterative implementation of search
	 */
	public boolean search(String word) {
		TrieNode current = root;
		
		for(int i=0; i<word.length();i++) {
			char ch = word.charAt(i);
			
			TrieNode node = current.children.get(ch);
			if(node == null) {
				return false;
			}
			current = node;
		}
		
		return current.isEndOfWord;
	}

}
