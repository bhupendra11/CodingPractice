package com.prep2023.trees.segmenttree;

/**
 * A Java implementation of a Segment Tree data structure.
 */
public class SegmentTree {

    // Segment tree data structure
    static int[] segmentTree;

    public SegmentTree(int n) {
        segmentTree = new int[4 * n + 1];
    }

    /**
     * Main function to demonstrate the use of a Segment Tree.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] inputArray = {1, 3, 2, -2, 4, 5};
        int arrayLength = inputArray.length;

        // Initialize the segment tree with an appropriate size.
        segmentTree = new int[4 * arrayLength + 1];

        // Build the segment tree
        buildSegmentTree(1, inputArray, 0, arrayLength - 1);

        // Print the segment tree for visualization
        printSegmentTree();

        // Example Queries
        int query1 = query(2, 4, 1, 0, arrayLength - 1);
        int query2 = query(1, 4, 1, 0, arrayLength - 1);
        int query3 = query(3, 3, 1, 0, arrayLength - 1);

        System.out.println("Query Results:");
        System.out.println("Query 1 (2, 4): " + query1);
        System.out.println("Query 2 (1, 4): " + query2);
        System.out.println("Query 3 (3, 3): " + query3);

        // Example Update
        updateNode(1, 0, arrayLength - 1, 2, 100);

        // Print the updated segment tree
        printSegmentTree();

        // Perform queries after the update
        query1 = query(2, 4, 1, 0, arrayLength - 1);
        query2 = query(1, 4, 1, 0, arrayLength - 1);

        System.out.println("Query Results After Update:");
        System.out.println("Query 1 (2, 4): " + query1);
        System.out.println("Query 2 (1, 4): " + query2);
    }

    /**
     * Builds the segment tree recursively.
     *
     * @param stIndex The current index in the segment tree.
     * @param arr     The input array.
     * @param start   The start index of the current segment.
     * @param end     The end index of the current segment.
     */
    static void buildSegmentTree(int stIndex, int[] arr, int start, int end) {
        if (start == end) {
            // Leaf node
            segmentTree[stIndex] = arr[start];
            return;
        }

        int mid = start + (end - start) / 2;

        buildSegmentTree(2 * stIndex, arr, start, mid);
        buildSegmentTree(2 * stIndex + 1, arr, mid + 1, end);

        segmentTree[stIndex] = segmentTree[2 * stIndex] + segmentTree[2 * stIndex + 1];
    }

    /**
     * Performs a range query on the segment tree.
     *
     * @param queryStart The start of the query range.
     * @param queryEnd   The end of the query range.
     * @param stIndex    The current index in the segment tree.
     * @param start      The start index of the current segment.
     * @param end        The end index of the current segment.
     * @return The sum of elements in the specified range.
     */
    static int query(int queryStart, int queryEnd, int stIndex, int start, int end) {
        if (queryStart > end || queryEnd < start) {
            // No overlap with the current segment
            return 0;
        }

        if (start >= queryStart && end <= queryEnd) {
            // Total overlap with the current segment
            return segmentTree[stIndex];
        }

        int mid = start + (end - start) / 2;
        int leftSum = query(queryStart, queryEnd, 2 * stIndex, start, mid);
        int rightSum = query(queryStart, queryEnd, 2 * stIndex + 1, mid + 1, end);

        return leftSum + rightSum; // Partial overlap
    }

    /**
     * Updates an element in the input array and the corresponding node in the segment tree.
     *
     * @param stIndex   The current index in the segment tree.
     * @param start     The start index of the current segment.
     * @param end       The end index of the current segment.
     * @param position  The position of the element to update.
     * @param newValue  The new value for the element.
     */
    static void updateNode(int stIndex, int start, int end, int position, int newValue) {
        if (start == end) {
            // Total overlap (reached a leaf node)
            segmentTree[stIndex] = newValue;
            return;
        }

        int mid = start + (end - start) / 2;

        if (position <= mid) {
            // Update the left child if the position is in the left half
            updateNode(2 * stIndex, start, mid, position, newValue);
        } else {
            // Update the right child if the position is in the right half
            updateNode(2 * stIndex + 1, mid + 1, end, position, newValue);
        }

        segmentTree[stIndex] = segmentTree[2 * stIndex] + segmentTree[2 * stIndex + 1];
    }

    /**
     * Prints the segment tree for visualization.
     */
    private static void printSegmentTree() {
        System.out.println("Segment Tree:");
        for (int value : segmentTree) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}


/*
public class SegmentTree {

    // segment tree data structure
    //segTree is an array where we will store precomputed values for various subsegments of the input array.
    static int segTree[];
    public static void main(String[] args) {
        int arr[] = new int[]{1,3,2,-2,4,5};
        int n = arr.length;

        //segment tree will have max of 4n letters
        segTree = new int[4*n+1];
        //creating a 1 based index seg tree
        int stIndex = 1;   //It represents the index of the root node in the segment tree.

        //Initialize `start` and `end` to represent the range of the segment tree, initially covering the entire input array
        int start =0;
        int end = n-1;

        buildSegTree(stIndex, arr, start,end);

        for(int i: segTree){
            System.out.print(i+" ");
        }
        System.out.println();

        //query
        System.out.println(query(2,4,stIndex,start,end)); //
        System.out.println(query(1,4,stIndex,start,end));
        System.out.println(query(3,3,stIndex,start,end));

        //update
        updateNode(stIndex,start,end,2,100);
        for(int i: segTree){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(query(2,4,stIndex,start,end)); //
        System.out.println(query(1,4,stIndex,start,end));

    }

    private static void buildSegTree(int stIndex,int arr[], int start, int end) {
        if(start > end)return;
        if(start == end){ //LeafNode
            segTree[stIndex] = arr[start];
            return;
        }

        int mid = start + (end-start)/2;

        buildSegTree(2*stIndex, arr, start, mid);
        buildSegTree(2*stIndex+1,arr,mid+1,end);

        segTree[stIndex] = segTree[2*stIndex] + segTree[2*stIndex+1];
    }

    /**
     *
     * @param qs query start
     * @param qe query end
     * @param stIndex segmentTree Index
     * @param start
     * @param end
     * @return
     */
//    private static int query(int qs, int qe, int stIndex, int start, int end){
//        if(qs > end || qe < start) //No overlap
//            return 0;
//
//        if(start >= qs &&  end <= qe ){ //Total overlap
//            return segTree[stIndex];
//        }
//
//        //Partial Overlap
//        int mid = start + (end-start)/2;
//        int lsum = query(qs,qe,2*stIndex,start,mid);
//        int rsum = query(qs,qe, 2*stIndex+1, mid+1, end);
//        return lsum+rsum;
//    }
//
//
//    private static void updateNode(int stIndex, int start, int end, int pos, int newValue) {
//        if(start > pos || end < pos)return;
//        if(start == end){ //Total overlap
//            segTree[stIndex] = newValue;
//            return;
//        }
//
//        int mid = start + (end-start)/2;
//
//        updateNode(2*stIndex, start,mid, pos, newValue);
//        updateNode(2*stIndex+1,  mid+1,end, pos, newValue);
//
//        segTree[stIndex] = segTree[2*stIndex] + segTree[2*stIndex+1];
//    }
//
//}

