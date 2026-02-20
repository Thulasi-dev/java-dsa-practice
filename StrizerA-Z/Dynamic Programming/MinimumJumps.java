/* You are given an array arr[] of non-negative numbers. Each number tells you the maximum number of steps you can jump forward from that position.

For example:

If arr[i] = 3, you can jump 1 step, 2 steps, or 3 steps forward from position i.
If arr[i] = 0, you cannot jump forward from that position.
Your task is to find the minimum number of jumps needed to move from the first position in the array to the last position.

Note:  Return -1 if you can't reach the end of the array.*/

public class MinimumJumps {

    public static int minJumps(int[] arr) {
        int n = arr.length;
        
        // If the array has only one element or the first element is 0, check edge cases
        if (n <= 1) return 0;
        if (arr[0] == 0) return -1;
        
        // Initialize variables
        int jumps = 1; // At least one jump is required
        int maxReach = arr[0]; // Maximum index we can reach
        int steps = arr[0]; // Steps we can take before needing another jump

        for (int i = 1; i < n; i++) {
            // If we reach the end of the array, return the number of jumps
            if (i == n - 1) return jumps;

            // Update the maximum reachable index
            maxReach = Math.max(maxReach, i + arr[i]);

            // Use a step to move forward
            steps--;

            // If no steps are remaining
            if (steps == 0) {
                // Increment the jump count
                jumps++;

                // If we can't progress further, return -1
                if (i >= maxReach) return -1;

                // Update steps to the number of steps we can take from the new position
                steps = maxReach - i;
            }
        }

        return -1; // If we exit the loop, it means we can't reach the end
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        int[] arr2 = {1, 0, 3, 4};
        int[] arr3 = {0};

        System.out.println("Minimum jumps for arr1: " + minJumps(arr1)); // Output: 4
        System.out.println("Minimum jumps for arr2: " + minJumps(arr2)); // Output: -1
        System.out.println("Minimum jumps for arr3: " + minJumps(arr3)); // Output: -1
    }
}

/*Input Array 1: {2, 3, 1, 1, 2, 4, 2, 0, 1, 1}
Steps to calculate the output:

1. Start at index 0 (value = 2). You can jump up to 2 steps forward (to index 1 or 2).
2. Jump to index 1 (value = 3). Now you can jump up to 3 steps forward (to index 2, 3, or 4).
3. Jump to index 4 (value = 2). From here, you can jump up to 2 steps forward (to index 5 or 6).
4. Jump to index 5 (value = 4). From here, you can jump up to 4 steps forward, which allows you to reach the end of the array at index 9.
Output: 4 (It took 4 jumps to reach the end).*/
