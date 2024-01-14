package com.prep2023.dp.mem;

public class _2_IsOneEditDistance {
    //
    public boolean isOneEditDistance(String s, String t){
        if(s.isEmpty() && t.isEmpty())return false;
        if(s.isEmpty()){
            return t.length() ==1;
        }
        if(t.isEmpty()){
            return s.length() ==1;
        }

        if(Math.abs(s.length()-t.length()) >1)return false;

        //lets keep s as the shorter string
        if(s.length() > t.length()){
            return isOneEditDistance(t,s);
        }

        int ns = s.length();
        int nt = t.length();
        for(int i=0;i<ns;i++){

            if(s.charAt(i) != t.charAt(i)){
                if(ns == nt){ //replace
                    return s.substring(i+1).equals(t.substring(i+1));
                }
                else{ //insert
                    return s.substring(i).equals(t.substring(i+1));
                }
            }

        }

        // if there is no character difference, then strings are 1 dist away
        // only when t is just one charactyer larger than s
        return ns +1 == nt;
    }




    //One solution is find the edit istance and check if it is 1
    // O(mn) , not really required here
    /*public boolean isOneEditDistance(String s, String t) {
        if(s.isEmpty() && t.isEmpty())return false;
        if(s.isEmpty()){
            return t.length() ==1;
        }
        if(t.isEmpty()){
            return s.length() ==1;
        }

        int m = s.length();
        int n = t.length();

        int dp[][] = new int[m+1][n+1];

        //first col
        for(int i=0; i<= m;i++){
            dp[i][0] =i;
        }

        for(int i=0; i<=n ;i++){
            dp[0][i] =i;
        }

        for(int i=1; i <= m ; i++){
            for(int j=1; j <= n; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(
                        dp[i][j-1], //insert
                        Math.min(
                            dp[i-1][j], //delete
                            dp[i-1][j-1] //replace
                        )
                    );
                }
            }
        }

        return dp[m][n] ==1;
    }*/
}
