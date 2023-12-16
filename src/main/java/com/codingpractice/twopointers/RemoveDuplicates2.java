package com.codingpractice.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 200, 200, 200, 3,4,4);
        int result = removeDuplicates(list);
        System.out.println("MaximumScoreAfterOperations="+result );
    }

    public static int removeDuplicates(List<Integer> a) {

        int i=0;  //normally traveses array
        int j=0;  //keep track of single elements
        int n = a.size();
        for(i=0;i<n-1 ;i++){

            System.out.println("At i= "+i+" = "+a.get(i));
            System.out.println("At i+1= "+(i+1)+" = "+a.get(i+1));

            if(a.get(i) != a.get(i+1)){

                System.out.println("Inside i= "+i);
                a.set(j,a.get(i));
                j++;
            }
        }
        a.set(j,a.get(n-1));
        System.out.println("j= "+j);
        return j+1;
    }
}
