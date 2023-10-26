package com.codingpractice.trie;

import java.util.HashMap;

/**
 * 
 * @author Bhupendra Shekhawat
 * The logic is to use a frequency field for trieNode and increase frequecy for a chacter node on insertion.
 * While getting shortest prefix, return the word formed by traversing to the nearest node where frequecy is 1
 */

public class ShortestUniquePrefix {

	public static void main(String args[]) {

		//String words[] = { "zebra", "dog", "duck", "dove" };
		String words[] = { "bearcat", "bert" };

		Trie trie = new Trie();

		for (String word : words) {
			trie.insert(word);
		}

		String result[] = new String[words.length];

		for (int i = 0; i < words.length; i++) {
			result[i] = trie.getShortestuniquePrefix(words[i]);
			System.out.println(result[i]);
		}
	}

	public static class Trie {

		public TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public class TrieNode {
			public HashMap<Character, TrieNode> children;
			boolean endOfWord;
			int frequency;

			public TrieNode() {
				children = new HashMap<>();
				endOfWord = false;
				this.frequency =0;
			}
		}

		public void insert(String word) {
			TrieNode current = root;

			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);

				TrieNode node = current.children.get(ch);
				
				if (node == null) {
					node = new TrieNode();
					current.children.put(ch, node);
				}
				node.frequency++;
				current = node;
			}
			current.endOfWord = true;
		}

		public String getShortestuniquePrefix(String word) {
			String result = "";
			TrieNode current = root;
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);

				TrieNode node = current.children.get(ch);
				result += ch;
				if (node == null)
					return result;
				if (node.frequency == 1){
					return result;
				}
				current = node;
			}
			return result;
		}
	}

}
