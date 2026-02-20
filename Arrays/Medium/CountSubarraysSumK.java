/* Given an integer array nums and an integer k,
count the number of continuous subarrays whose sum equals k.

✅ Optimal Solution – Prefix Sum + HashMap
⏱ Time Complexity: O(n)
💾 Space Complexity: O(n) */

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysSumK {
    public static int countSubarrays(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();

        // Important: prefix sum 0 occurs once
        prefixSumCount.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // Check if (currentSum - k) exists
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }

            // Store/update current prefix sum
            prefixSumCount.put(currentSum,
                    prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int k = 2;

        System.out.println(countSubarrays(arr, k)); // Output: 2
    }
}

/* Subarrays:
[1, 1] (index 0–1)
[1, 1] (index 1–2) */
