// 3719 Longest Balanced Subarray I (MEDIUM)

/*You are given an integer array nums.

A subarray is called balanced if the number of distinct even numbers in the subarray is equal to the number of distinct odd numbers.

Return the length of the longest balanced subarray.

Time O(n)
Space O(n)*/  insctcsrc 6215461002  insccpstrc


import java.util.*;

class Solution {
    public int longestBalancedSubarray(int[] nums) {
        Set<Integer> evenSet = new HashSet<>();
        Set<Integer> oddSet = new HashSet<>();

        Map<Integer, Integer> freq = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];

            // add frequency
            freq.put(num, freq.getOrDefault(num, 0) + 1);

            // add to distinct set if first time
            if (freq.get(num) == 1) {
                if (num % 2 == 0) {
                    evenSet.add(num);
                } else {
                    oddSet.add(num);
                }
            }

            // check balance
            if (evenSet.size() == oddSet.size()) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // shrink window if needed
            while (evenSet.size() > oddSet.size() || oddSet.size() > evenSet.size()) {
                int removeNum = nums[left];
                freq.put(removeNum, freq.get(removeNum) - 1);

                if (freq.get(removeNum) == 0) {
                    freq.remove(removeNum);
                    if (removeNum % 2 == 0) {
                        evenSet.remove(removeNum);
                    } else {
                        oddSet.remove(removeNum);
                    }
                }
                left++;

                if (evenSet.size() == oddSet.size()) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
            }
        }
        return maxLen;
    }
}
