package com.codingpractice.binarysearch;

/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 *
 * https://www.youtube.com/watch?v=X45c37QMdX0&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=12
 *
 *Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest character in the array that is larger than target.
 *
 * Note that the letters wrap around.
 *
 * For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
 *
 *
 * Example 1:
 *
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 * Example 2:
 *
 * Input: letters = ["c","f","j"], target = "c"
 * Output: "f"
 * Example 3:
 *
 * Input: letters = ["c","f","j"], target = "d"
 * Output: "f"
 */
public class VIII_NextAlphabeticalOrderElement {
    public static void main(String[] args) {
        char letters[] = {'c','f','j'};
        char target = 'a';

        System.out.println(nextGreatestLetter(letters,target));

        letters = new char[]{'c','f','j'};
        target = 'c';

        System.out.println(nextGreatestLetter(letters,target));

        letters = new char[]{'a','b','g'};
        target = 'z';

        System.out.println(nextGreatestLetter(letters,target));
    }

    private static char nextGreatestLetter(char[] letters, char target) {

        int n = letters.length;
        int low =0;
        int high =n-1;
        int mid =0;
        char result='-';

        while(low<=high){

            mid = low +(high-low)/2;

            if(letters[mid] >target){
                result = letters[mid];
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        //address for last element wrap around
        if(result =='-' && mid ==high)return letters[0];

        return result;

    }
}
