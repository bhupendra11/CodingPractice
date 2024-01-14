package com.bhupendra.prep2023.arrays.binarySearch;

/**
 * Author: Bhupendra Shekhawat
 * Date: 28/12/23
 * Topic: com.prep2023.arrays.binarySearch
 * Question : <a href="https://www.interviewbit.com/problems/implement-power-function"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _15_MathPow {

    public int pow(int x, int n, int d) {
        if (x == 0 || n == 1)
            return mod(x, d);

        if (n == 0)
            return 1;

        long tmp = mod((long) x * x, d);

        if (n % 2 == 0) {
            return mod((pow((int) tmp, n / 2, d)), d);
        }

        return mod(((long) x * pow((int) tmp, n / 2, d)), d);
    }

    private int mod(long x, int d) {
        return (int) (x % d + d) % d;
    }
}
