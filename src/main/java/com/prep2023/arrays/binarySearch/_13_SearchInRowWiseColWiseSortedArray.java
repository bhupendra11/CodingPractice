package com.prep2023.arrays.binarySearch;

/**
 * Author: Bhupendra Shekhawat
 * Date: 28/12/23
 * Topic: com.prep2023.arrays.binarySearch
 * Question : <a href="https://leetcode.com/problems/search-a-2d-matrix/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _13_SearchInRowWiseColWiseSortedArray {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols -1;

        while(row < rows && col >=0){
            int cur = matrix[row][col];
            if(cur == target){
                return true;
            }
            else if(target > cur){
                row++;
            }
            else{
                col--;
            }
        }
        return false;
    }
}
