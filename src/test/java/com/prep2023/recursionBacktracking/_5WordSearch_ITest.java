package com.prep2023.recursionBacktracking;

import org.junit.Test;
import static org.junit.Assert.*;

public class _5WordSearch_ITest {

    @Test
    public void testExistWithValidWord() {
        _5WordSearch_I wordSearch = new _5WordSearch_I();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        assertTrue(wordSearch.exist(board, "ABCCED"));
    }

    @Test
    public void testExistWithInvalidWord() {
        _5WordSearch_I wordSearch = new _5WordSearch_I();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        assertFalse(wordSearch.exist(board, "ABCB"));
    }

    @Test
    public void testExistWithEmptyBoard() {
        _5WordSearch_I wordSearch = new _5WordSearch_I();
        char[][] board = {};
        assertFalse(wordSearch.exist(board, "ABCD"));
    }

    @Test
    public void testExistWithEmptyWord() {
        _5WordSearch_I wordSearch = new _5WordSearch_I();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        assertTrue(wordSearch.exist(board, ""));
    }

    @Test
    public void testExistWithSingleCharacterWord() {
        _5WordSearch_I wordSearch = new _5WordSearch_I();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        assertTrue(wordSearch.exist(board, "A"));
    }

    @Test
    public void testExistWithNonSquareBoard() {
        _5WordSearch_I wordSearch = new _5WordSearch_I();
        char[][] board = {
                {'A', 'B', 'C'},
                {'S', 'F', 'C'},
                {'A', 'D', 'E'}
        };
        assertTrue(wordSearch.exist(board, "ABC"));
    }

    @Test
    public void testExistWithNonexistentWord() {
        _5WordSearch_I wordSearch = new _5WordSearch_I();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        assertFalse(wordSearch.exist(board, "XYZ"));
    }
}
