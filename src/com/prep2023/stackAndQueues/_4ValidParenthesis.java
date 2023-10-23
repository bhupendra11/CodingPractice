package com.prep2023.stackAndQueues;

import java.util.Stack;

/**
 * Author: Bhupendra Shekhawat
 * Date: 23/10/23
 * Topic: com.prep2023.stackAndQueues
 * Question Link: https://leetcode.com/problems/valid-parentheses/description/
 * YouTube Link: 
 * Problem:
 *
 * 20. Valid Parentheses

 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 */

public class _4ValidParenthesis {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char b : s.toCharArray()){
            if(isClose(b)){
                if(stack.isEmpty() || !isMatch(stack.pop(),b))return false;
            }
            else{
                stack.push(b);
            }

        }
        return stack.isEmpty();

    }

    private boolean isClose(char c){
        return c ==']' || c =='}' || c == ')';
    }
    private boolean isMatch(char a, char b){
        return (a =='[' && b == ']')
                || (a =='{' && b == '}')
                || (a =='(' && b == ')');
    }

    public static void main(String[] args) {
        _4ValidParenthesis solution = new _4ValidParenthesis();

        // Test cases
        String s1 = "([]{})"; // Valid
        String s2 = "([)]";   // Invalid
        String s3 = "{[()]}"; // Valid
        String s4 = "({[}])"; // Invalid

        System.out.println("String " + s1 + " is valid: " + solution.isValid(s1));
        System.out.println("String " + s2 + " is valid: " + solution.isValid(s2));
        System.out.println("String " + s3 + " is valid: " + solution.isValid(s3));
        System.out.println("String " + s4 + " is valid: " + solution.isValid(s4));
    }
}
