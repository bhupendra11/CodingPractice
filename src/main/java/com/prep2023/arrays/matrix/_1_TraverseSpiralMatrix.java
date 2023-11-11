package com.prep2023.arrays.matrix;

import java.util.ArrayList;
import java.util.List;

public class _1_TraverseSpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int dir =0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = cols -1;

        int up =0;
        int down = rows -1;


        while(left <= right && up <= down){
            if(dir ==0){ //left to right
                for(int i=left;i<= right;i++){
                    result.add(matrix[up][i]);
                }
                up++;
                dir++;
            }
            else if(dir ==1){ // up to down
                for(int i=up;i<= down;i++){
                    result.add(matrix[i][right]);
                }
                right--;
                dir++;
            }
            else if(dir ==2){ //right to left
                for(int i=right;i>= left;i--){
                    result.add(matrix[down][i]);
                }
                down--;
                dir++;
            }
            else{//down to up
                for(int i=down;i>= up;i--){
                    result.add(matrix[i][left]);
                }
                left++;
                dir =0;
            }
        }
        return result;
    }
}