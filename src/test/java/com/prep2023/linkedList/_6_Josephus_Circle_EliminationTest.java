package com.prep2023.linkedList;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _6_Josephus_Circle_EliminationTest {

    @Test
    public void testFindLastPerson() {
        assertEquals(4, _6_Josephus_Circle_Elimination.findLastPerson(7, 3));
        assertEquals(3, _6_Josephus_Circle_Elimination.findLastPerson(5, 2));
        assertEquals(1, _6_Josephus_Circle_Elimination.findLastPerson(1, 1));
        assertEquals(7, _6_Josephus_Circle_Elimination.findLastPerson(7, 1));
        assertEquals(4, _6_Josephus_Circle_Elimination.findLastPerson(5, 3));
    }
}