package com.codingpractice.backtrackingAndRecursion;

public class IV_Substrings {
    public static void main(String[] args) {
        substring("ABC");
    }

    private static void substring(String str){
        printSubs(str,"");
    }

    private static void printSubs(String rest, String soFar){
        if(rest.length()==0){
            System.out.println(soFar);
            return;
        }
        char cur = rest.charAt(0);
        //leave cur
        printSubs(rest.substring(1),soFar);
        //include cur
        printSubs(rest.substring(1),soFar+cur);

    }
}
