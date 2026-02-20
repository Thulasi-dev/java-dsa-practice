/*Longest Subarray with given Sum K(Positives)
Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0.

Input:
nums = [10, 5, 2, 7, 1, 9], k = 15  
Output: 4   

Time: O(n)
Space: O(n) */
import java.util.HashMap;

public class LongestSubarraySumK {

    public static int longestSubarray(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        // Important base case
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // Check if (prefixSum - k) exists
            if (map.containsKey(prefixSum - k)) {
                int length = i - map.get(prefixSum - k);
                maxLen = Math.max(maxLen, length);
            }

            // Store first occurrence only
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, -1, 2, 1, 1, 1};
        int k = 3;
        System.out.println(longestSubarray(nums, k));
    }
}

// [1, -1, 2, 1] → sum = 3 → length = 4

