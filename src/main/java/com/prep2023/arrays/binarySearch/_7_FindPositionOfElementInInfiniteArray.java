package com.prep2023.arrays.binarySearch;

public class _7_FindPositionOfElementInInfiniteArray {

    //Simple steps
    /**
     * When given array is infinite, maybe 1 element is inserted at a time like a stream or something like that
     *
     * start with low =0
     *            high =1
     *
     *            till the time targert is not in the range of low..high , keep doubling high
     *           high = 2
     *           high = 4;
     *           high = 8
     *           high = 16....
     *
     *           When target is between low ... high
     *
     *           Do normal binary search since you have a proper range now
     *
     */
}
