package com.prep2023.graph.apsp_floyd_warshall;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.List.*;
import static org.junit.jupiter.api.Assertions.*;

public class CourseScheduleIVTest {

    @Test
    public void testCheckIfPrerequisiteExample1() {
        CourseScheduleIV courseScheduleIV = new CourseScheduleIV();

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        int[][] queries1 = {{0, 1}, {1, 0}};
        List<Boolean> expected1 = Arrays.asList(false, true);

        List<Boolean> result1 = courseScheduleIV.checkIfPrerequisite(numCourses1, prerequisites1, queries1);
        assertEquals(expected1, result1);
    }

    @Test
    public void testCheckIfPrerequisiteExample2() {
        CourseScheduleIV courseScheduleIV = new CourseScheduleIV();

        int numCourses2 = 2;
        int[][] prerequisites2 = {};
        int[][] queries2 = {{1, 0}, {0, 1}};
        List<Boolean> expected2 = Arrays.asList(false, false);

        List<Boolean> result2 = courseScheduleIV.checkIfPrerequisite(numCourses2, prerequisites2, queries2);
        assertEquals(expected2, result2);
    }
}