/*Longest Consecutive Sequence

Given an array of integers nums, return the length of the longest consecutive sequence of elements that can be formed.

A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element. The elements do not have to be consecutive in the original array.

You must write an algorithm that runs in O(n) time.
Input: nums = [2,20,4,10,3,4,5]
Output: 4

Input: nums = [0,3,2,5,4,6,1,1]
Output: 7
| Metric           | Value    |
| ---------------- | -------- |
| Time Complexity  | O(n) |
| Space Complexity | O(n) |

*/

import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Step 1: Store all numbers in HashSet
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Step 2: Find consecutive sequences
        for (int num : set) {

            // Check if num is the start of a sequence
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int count = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
