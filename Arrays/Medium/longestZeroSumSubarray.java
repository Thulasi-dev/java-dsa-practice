// Largest subarray with 0 sum

/*Given an array arr[] containing both positive and negative integers, the task is to find the length of
 the longest subarray with a sum equals to 0.

Note: A subarray is a contiguous part of an array, formed by selecting one or more consecutive elements 
while maintaining their original order.
Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
Output: 5
Explanation: The longest subarray with sum equals to 0 is [-2, 2, -8, 1, 7].*/

import java.util.HashMap;

public static int longestZeroSumSubarray(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int prefixSum = 0;
    int maxLen = 0;

    for (int i = 0; i < arr.length; i++) {
        prefixSum += arr[i];

        if (prefixSum == 0) {
            maxLen = i + 1;
        }

        if (map.containsKey(prefixSum)) {
            int prevIndex = map.get(prefixSum);
            int len = i - prevIndex;
            if (len > maxLen) {
                maxLen = len;
            }
        } else {
            map.put(prefixSum, i);
        }
    }

    return maxLen;
}

// O(n) time, O(n) space
