// Make a Distinct Digit Array

/*Given an array nums of positive integers of size N. Find all distinct digits present in nums.
Input: nums = [131, 11, 48]
Output: 1 3 4 8
Explanation: 1, 3, 4, and 8 are only distinct digits that can be extracted from the numbers of the array.
*/

import java.util.ArrayList;

public class Solution {

    public static int[] common_digits(int[] nums) {
        boolean[] seen = new boolean[10]; // digits 0-9

        // Mark all digits present in nums
        for (int num : nums) {
            while (num > 0) {
                int digit = num % 10;
                seen[digit] = true;
                num /= 10;
            }
        }

        // Count how many distinct digits
        int count = 0;
        for (boolean b : seen) {
            if (b) count++;
        }

        // Collect them
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (seen[i]) {
                result[index++] = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {123, 456, 789, 12};
        int[] res = common_digits(nums);
        for (int d : res) System.out.print(d + " ");
    }
}

/*“I maintain a boolean array of size 10 to track digits 0–9.
For each number, I extract its digits using %10 and /10 and mark them.
Finally, I collect all digits that appeared. This ensures O(1) extra space and O(N × digits) time.”*/