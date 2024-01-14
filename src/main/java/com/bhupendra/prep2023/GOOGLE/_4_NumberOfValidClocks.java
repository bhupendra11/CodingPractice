package com.bhupendra.prep2023.GOOGLE;


/**
 * Author: Bhupendra Shekhawat
 * Date: 20/11/23
 * Topic: com.prep2023.GOOGLE
 * Question : <a href="https://leetcode.com/problems/number-of-valid-clock-times/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _4_NumberOfValidClocks {
    public int countTime(String time) {
        String timearr[] = time.split(":");
        String first = timearr[0];
        String second = timearr[1];

        int combFirst = findFirst(first);
        int combSecond = findSecond(second);

        return combFirst * combSecond;
    }

    // for hh
    private int findFirst(String str){
        if(str.equals("??")){
            return 24;
        }

        if(str.charAt(0)=='?'){
            if(str.charAt(1) <= '3'){
                return 3;
            }
            return 2;
        }
        else if(str.charAt(1)=='?'){
            if(str.charAt(0) =='2'){
                return 4;
            }
            return 10;
        }
        return 1;
    }

    // for mm -- 0 -> 59
    private int findSecond(String str){
        if(str.equals("??")){
            return 60;
        }

        if(str.charAt(0) =='?'){
            return 6;
        }
        else if(str.charAt(1) =='?') return 10;

        return 1;
    }
}