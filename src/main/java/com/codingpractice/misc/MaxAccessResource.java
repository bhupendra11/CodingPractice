package com.codingpractice.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID.
 * <p>
 * The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.
 * <p>
 * Example:
 * logs1 = [
 * ["58523", "user_1", "resource_1"],
 * ["62314", "user_2", "resource_2"],
 * ["54001", "user_1", "resource_3"],
 * ["200", "user_6", "resource_5"],
 * ["215", "user_6", "resource_4"],
 * ["54060", "user_2", "resource_3"],
 * ["53760", "user_3", "resource_3"],
 * ["58522", "user_22", "resource_1"],
 * ["53651", "user_5", "resource_3"],
 * ["2", "user_6", "resource_1"],
 * ["100", "user_6", "resource_6"],
 * ["400", "user_7", "resource_2"],
 * ["100", "user_8", "resource_6"],
 * ["54359", "user_1", "resource_3"],
 * ]
 * <p>
 * Example 2:
 * logs2 = [
 * ["300", "user_1", "resource_3"],
 * ["599", "user_1", "resource_3"],
 * ["900", "user_1", "resource_3"],
 * ["1199", "user_1", "resource_3"],
 * ["1200", "user_1", "resource_3"],
 * ["1201", "user_1", "resource_3"],
 * ["1202", "user_1", "resource_3"]
 * ]
 * <p>
 * Example 3:
 * logs3 = [
 * ["300", "user_10", "resource_5"]
 * ]
 * <p>
 * Write a function that takes the logs and returns the resource with the highest number of accesses in any 5 minute window, together with how many accesses it saw.
 * <p>
 * Expected Output:
 * most_requested_resource(logs1) # => ('resource_3', 3)
 * Reason: resource_3 is accessed at 53760, 54001, and 54060
 * <p>
 * most_requested_resource(logs2) # => ('resource_3', 4)
 * Reason: resource_3 is accessed at 1199, 1200, 1201, and 1202
 * <p>
 * most_requested_resource(logs3) # => ('resource_5', 1)
 * Reason: resource_5 is accessed at 300
 * <p>
 * Complexity analysis variables:
 * <p>
 * n: number of logs in the input
 */
public class MaxAccessResource {

    private static int TIME_WINDOW= 300;
    public static void main(String[] args) {
        String logs1[][] = {
                {"58523", "user_1", "resource_1"},
                {"62314", "user_2", "resource_2"},
                {"54001", "user_1", "resource_3"},
                {"200", "user_6", "resource_5"},
                {"215", "user_6", "resource_4"},
                {"54060", "user_2", "resource_3"},
                {"53760", "user_3", "resource_3"},
                {"58522", "user_22", "resource_1"},
                {"53651", "user_5", "resource_3"},
                {"2", "user_6", "resource_1"},
                {"100", "user_6", "resource_6"},
                {"400", "user_7", "resource_2"},
                {"100", "user_8", "resource_6"},
                {"54359", "user_1", "resource_3"},
        };

        String logs2[][] = {
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}
        };

    String logs3[][] = {
            {"300", "user_10", "resource_5"}
    };


        String result[] = parse(logs1);
        System.out.println("{ "+result[0]+" , "+result[1]+" }");

        result = parse(logs2);
        System.out.println("{ "+result[0]+" , "+result[1]+" }");

        result = parse(logs3);
        System.out.println("{ "+result[0]+" , "+result[1]+" }");

    }

    private static String[] parse(String[][] logs){
        int n = logs.length;
        Arrays.sort(logs, (a,b)-> Integer.valueOf(a[0])-Integer.valueOf(b[0]));
      //  printArr(logs);

        // Map <Resource, Frequency>
        Map<String, Integer> freqMap = new HashMap<>();

        int start =0;
        int end =1;
        int maxFreq =1;
        String maxResource = logs[0][2];

        freqMap.put(logs[0][2], 1);

        while(end < logs.length){
            int time = Integer.valueOf(logs[end][0]);
            while(time - Integer.valueOf(logs[start][0]) > TIME_WINDOW ){
                freqMap.put(logs[start][2],freqMap.get(logs[start][2])-1);
                start++;
            }
            freqMap.put( logs[end][2] ,freqMap.getOrDefault(logs[end][2],0)+1);
            if(maxFreq <= freqMap.get(logs[end][2])){
                maxFreq = freqMap.get(logs[end][2]);
                maxResource = logs[end][2];
            }
            end++;
        }

        return new String[]{maxResource,maxFreq+""};
    }

    private static void printArr(String logs[][]){
        for(String[] log : logs){
            System.out.println(log[0] +" "+log[1]+" "+log[2]);
        }
    }
}

