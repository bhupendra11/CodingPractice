package com.prep2023.recursionBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Approach 2: Generate all combinations using backtracking and keep them valid while generating
//Make sure not to generate invalid combination
//This is much faster
public class _2GenerateParenthesis {

    List<String>  result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        backtrack(new StringBuilder(),0,0,n);
        return result;
    }

    private void backtrack(StringBuilder cur, int leftCount, int rightCount, int n) {
        if(cur.length() == 2*n){
            result.add(cur.toString());
        }

        if(leftCount < n){
            cur.append('(');
            backtrack(cur,leftCount+1,rightCount,n);
            cur.deleteCharAt(cur.length()-1);
        }
        if(leftCount > rightCount){
            cur.append(')');
            backtrack(cur,leftCount,rightCount+1,n);
            cur.deleteCharAt(cur.length()-1);
        }
    }

    public static void main(String[] args) {
        _2GenerateParenthesis generateParenthesis = new _2GenerateParenthesis();
        List<String> parenthesisCombs = generateParenthesis.generateParenthesis(3);
        System.out.println(parenthesisCombs);
    }

}

//Approach 1 : Generate all combinations using backtraking and filter only valid
// Not efficient as also make invalid combinations
/*public class _2GenerateParenthesis {

    List<String>  result;
    char arr[] ;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        arr = new char[]{'(',')'};

        backtrack(new StringBuilder(), n*2);
        return result;
    }

    private void backtrack(StringBuilder sb, int n){
        if(sb.length()==n){
            if(isValid(sb.toString())){
                result.add(sb.toString());
            }

            return ;
        }

        for(char c : arr){
            sb.append(c);
            backtrack(sb,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private boolean isValid(String s ){
        Stack<Character> stack = new Stack<>();
        for( char c : s.toCharArray()){
            if(c == '('){
                stack.push(c);
            }
            else{ // c=')'
                if(stack.isEmpty())return false;
                stack.pop();
            }
        }
        return stack.size() ==0;
    }
}*/
