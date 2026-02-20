// Artithmetic Slices

/* An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array. */

class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        
        // If length is less than 3, no arithmetic subarray possible
        if (nums.length < 3) return 0;

        int total = 0;   // Final answer
        int curr = 0;    // Number of arithmetic subarrays ending at current index

        for (int i = 2; i < nums.length; i++) {

            // Check if current three numbers form arithmetic
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr = curr + 1;   // Extend previous arithmetic slices
                total = total + curr;
            } else {
                curr = 0;  // Break in arithmetic pattern
            }
        }

        return total;
    }
}

/* Input: nums = [1,2,3,4]
   Output: 3
   Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself. */
