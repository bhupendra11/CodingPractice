package com.codingpractice.backtrackingAndRecursion;

public class III_Permutations {
    public static void main(String[] args) {
        printPerms("ABC");
    }

    private static void printPerms(String str){
        permutations(str,"");
    }

    private static void permutations(String rest, String soFar){
        if(rest.length()==0){
            System.out.println(soFar);
            return;
        }
        for(int i=0;i<rest.length();i++){
            char cur = rest.charAt(i);
            String remaining = rest.substring(0,i) + rest.substring(i+1);
            permutations(remaining,soFar+cur);
        }

    }
}
