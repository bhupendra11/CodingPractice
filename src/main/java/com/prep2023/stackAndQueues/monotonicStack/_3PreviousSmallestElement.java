package com.prep2023.stackAndQueues.monotonicStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class _3PreviousSmallestElement {

    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<A.size();i++){
            while(!stack.isEmpty() && stack.peek() >= A.get(i)){
                stack.pop();
            }

            if(stack.isEmpty()){
                result.add(-1);
            }
            else{
                result.add(stack.peek());
            }
            stack.push(A.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        // Test case 1
        ArrayList<Integer> input1 = new ArrayList<>(Arrays.asList(4, 5, 2, 10, 8));
        ArrayList<Integer> result1 = prevSmaller(input1);
        Integer[] expected1 = {-1, 4, -1, 2, 2};

        System.out.println("Test Case 1:");
        System.out.println("Expected: " + Arrays.toString(expected1));
        System.out.println("Actual: " + result1);
        System.out.println("Test Status: " + (Arrays.equals(expected1, result1.toArray()) ? "Pass" : "Fail"));
        System.out.println();

        // Test case 2
        ArrayList<Integer> input2 = new ArrayList<>(Arrays.asList(1, 3, 0, 2, 5));
        ArrayList<Integer> result2 = prevSmaller(input2);
        Integer[] expected2 = {-1, 1, -1, 0, 2};

        System.out.println("Test Case 2:");
        System.out.println("Expected: " + Arrays.toString(expected2));
        System.out.println("Actual: " + result2);
        System.out.println("Test Status: " + (Arrays.equals(expected2, result2.toArray()) ? "Pass" : "Fail"));
        System.out.println();

        // You can add more test cases here.

    }
}
