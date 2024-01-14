package com.bhupendra.prep2023.dp.lcs;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _2_LongestCommonSubstringTest {

    @Test
    public void testLongestCommonSubstr() {
        _3_LongestCommonSubstring obj = new _3_LongestCommonSubstring();

        // Test Case 1: Small inputs with a common substring
        Assertions.assertEquals(4, obj.longestCommonSubstr("abcdxyz", "xyzabcd", 7, 7));

        // Test Case 2: Small inputs with no common substring
        Assertions.assertEquals(0, obj.longestCommonSubstr("abcdef", "xyz123", 6, 6));

        // Test Case 3: Large inputs with a common substring
        String largeInput1 = "abcdefghij" + "k" + "lmnopqrstuvwx";
        String largeInput2 = "1234567890" + "k" + "lmnopqrstuvwx";
        Assertions.assertEquals(14, obj.longestCommonSubstr(largeInput1, largeInput2, largeInput1.length(),
                largeInput2.length()));

        // Test Case 4: Large inputs with no common substring
        String largeInput3 = "abcdefghij" + "k" ;
        String largeInput4 = "1234567890" + "z" ;
        Assertions.assertEquals(0, obj.longestCommonSubstr(largeInput3, largeInput4, largeInput3.length(), largeInput4.length()));
    }
}
