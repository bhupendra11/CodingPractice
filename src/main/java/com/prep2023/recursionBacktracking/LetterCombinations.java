package com.prep2023.recursionBacktracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.put;

public class LetterCombinations {
    Map<Character,String> map;
    List<String> result;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if(digits ==null || digits.length()==0)return result;
        map = new HashMap<Character,String>(){
            {
                put('2',"abc");
                put('3',"def");
                put('4',"ghi");
                put('5',"jkl");
                put('6',"mno");
                put('7',"pqrs");
                put('8',"tuv");
                put('9',"wxyz");
            }
        };

        backtrack(digits,0,new StringBuilder());
        return result;

    }

    private void backtrack(String digits, int index, StringBuilder soFar){
        if(index == digits.length()){
            result.add(soFar.toString());
            return;
        }

        char num = digits.charAt(index);
        for(char c: map.get(num).toCharArray()){
            soFar.append(c+"");
            backtrack(digits,index+1, soFar);
            soFar.deleteCharAt(soFar.length()-1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> combinations = letterCombinations.letterCombinations("23");
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}
