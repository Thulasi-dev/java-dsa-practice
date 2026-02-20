/* 3379. Transformed Array (EASY)

You are given an integer array nums that represents a circular array. 
Your task is to create a new array result of the same size, following these rules:

You are given an array nums.
The array is circular, meaning:
    Going right from the last index wraps to the start.
    Going left from index 0 wraps to the end.
For each index i, you must jump based on the value at nums[i] and store the value where you land.

Rules

    nums[i] > 0 → move right nums[i] steps
    nums[i] < 0 → move left abs(nums[i]) steps
    nums[i] == 0 → result at i is 0

Each index is independent (don’t modify the original array).

Input: nums = [3,-2,1,1]
Output: [1,1,1,3] */

public class CircularArrayTransform {

    public static int[] getResult(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                int newIndex = ((i + nums[i]) % n + n) % n;
                result[i] = nums[newIndex];
            }
        }

        return result;
    }

    // For testing
    public static void main(String[] args) {
        int[] nums = {2, -1, 0, 3};
        int[] result = getResult(nums);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}

// Time: O(n)
// Space: O(n)