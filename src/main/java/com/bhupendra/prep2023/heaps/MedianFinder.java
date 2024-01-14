package com.bhupendra.prep2023.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Author: Bhupendra Shekhawat
 * Date: 21/10/23
 * Topic: com.prep2023.heaps
 * Question Link: https://leetcode.com/problems/find-median-from-data-stream/description/
 * YouTube Link: 
 * Problem:

 295. Find Median from Data Stream

 Hard

 The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

 For example, for arr = [2,3,4], the median is 3.
 For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 Implement the MedianFinder class:

 MedianFinder() initializes the MedianFinder object.
 void addNum(int num) adds the integer num from the data stream to the data structure.
 double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.


 Example 1:

 Input
 ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 [[], [1], [2], [], [3], []]
 Output
 [null, null, null, 1.5, null, 2.0]

 Explanation
 MedianFinder medianFinder = new MedianFinder();
 medianFinder.addNum(1);    // arr = [1]
 medianFinder.addNum(2);    // arr = [1, 2]
 medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
 medianFinder.addNum(3);    // arr[1, 2, 3]
 medianFinder.findMedian(); // return 2.0


 Constraints:

 -105 <= num <= 105
 There will be at least one element in the data structure before calling findMedian.
 At most 5 * 104 calls will be made to addNum and findMedian.


 Follow up:

 If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 */


class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        //maxHeap will store the first half
        //minHeap will store the second half

        //in case of odd elements , the maxHeap will have 1 more element than minHeap
        //I need to make sure, all the elements in the maxHeap are less than every element in minHeap
        // and thats how I can be sure that I can use the highest element in maxHeap and loweset in minHeap to find my median at any time.

    }
    
    public void addNum(int num) {   
        if(maxHeap.size()==0){
            maxHeap.add(num);
            return;
        }
        
        if(minHeap.size() < maxHeap.size()){ //need to add in minHeap
            maxHeap.add(num);
            minHeap.add(maxHeap.remove());
        }
        else{ //need to add in maxHeap
            if(num < minHeap.peek()){
                maxHeap.add(num);
            }
            else{
                minHeap.add(num);
                maxHeap.add(minHeap.remove());
            }
        }


        
    }
    
    public double findMedian() {
        int sizeleft = maxHeap.size();
        int sizeRight = minHeap.size();

        if((sizeleft+sizeRight)%2 == 0 ){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        else{ //if odd then I know that sizeLeft is bigger 
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        // Test case 1
        testMedianFinder(new int[]{1, 2, 3}, 2.0);

        // Test case 2
        testMedianFinder(new int[]{4, 5, 6, 7}, 5.5);

        // Test case 3
        testMedianFinder(new int[]{3, 1, 4, 2, 7, 6, 5}, 4.0);
    }

    static void testMedianFinder(int[] numbers, double expectedMedian) {

        MedianFinder medianFinder = new MedianFinder();

        for (int num : numbers) {
            medianFinder.addNum(num);
        }

        double median = medianFinder.findMedian();

        System.out.println("Input numbers: " + java.util.Arrays.toString(numbers));
        System.out.println("Expected Median: " + expectedMedian);
        System.out.println("Calculated Median: " + median);
        System.out.println("Match: " + (median == expectedMedian));
        System.out.println();
    }


}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */