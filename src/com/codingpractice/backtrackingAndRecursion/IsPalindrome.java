package com.codingpractice.backtrackingAndRecursion;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("bananb"));
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("apple"));
        System.out.println(isPalindrome("malayalam"));

    }

    private static boolean isPalindrome(String s){
        if(s==null)return false;
        if(s.length()<=1)return true;
        return helper(s,0,s.length()-1);
    }

    public static boolean helper(String s, int start, int end){
        if(s==null)return false;
        if(end-start+1 <=1)return true;
        return s.charAt(start) == s.charAt(end) && helper(s,start+1,end-1);
    }
}
