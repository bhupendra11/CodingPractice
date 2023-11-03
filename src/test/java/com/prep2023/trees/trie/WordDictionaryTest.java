package com.prep2023.trees.trie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordDictionaryTest {

    @Test
    public void testAddWordAndSearch() {
        WordDictionary dictionary = new WordDictionary();

        // Add some words to the dictionary
        dictionary.addWord("apple");
        dictionary.addWord("banana");
        dictionary.addWord("cherry");

        // Test searching for existing words
        assertTrue(dictionary.search("apple"));
        assertTrue(dictionary.search("banana"));
        assertTrue(dictionary.search("cherry"));

        // Test searching for non-existing words
        assertFalse(dictionary.search("app"));
        assertFalse(dictionary.search("banan"));
        assertFalse(dictionary.search("cher"));
    }

    @Test
    public void testAddWordAndSearchWithWildcard() {
        WordDictionary dictionary = new WordDictionary();

        // Add some words to the dictionary
        dictionary.addWord("apple");
        dictionary.addWord("banana");
        dictionary.addWord("cherry");

        // Test searching with wildcard '.'
        assertTrue(dictionary.search("appl."));
        assertTrue(dictionary.search("ban..."));
        assertTrue(dictionary.search("ch...."));

        // Test searching with wildcard '.' for non-existing words
        assertFalse(dictionary.search("app.d"));
        assertFalse(dictionary.search("banan.."));
        assertFalse(dictionary.search("cherr...."));
    }

    @Test
    public void testAddWordAndSearchWithEmptyString() {
        WordDictionary dictionary = new WordDictionary();

        // Add some words to the dictionary
        dictionary.addWord("apple");
        dictionary.addWord("banana");
        dictionary.addWord("cherry");

        // Test searching with empty string
        assertFalse(dictionary.search(""));
    }

    @Test
    public void testAddWordAndSearchWithNullInput() {
        WordDictionary dictionary = new WordDictionary();

        // Add some words to the dictionary
        dictionary.addWord("apple");
        dictionary.addWord("banana");
        dictionary.addWord("cherry");

        // Test searching with null input
        assertFalse(dictionary.search(null));
    }
}
