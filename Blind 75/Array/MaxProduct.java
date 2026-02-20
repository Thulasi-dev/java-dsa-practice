// Given an integer array nums, find a subarray that has the largest product, and return the product.

// The test cases are generated so that the answer will fit in a 32-bit integer.

// Note that the product of an array with a single element is the value of that element.

public class MaxProductSubarray {
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) 
            return 0;

        // Initialize max and min products ending at current position
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // If the current number is negative, swap maxProd and minProd
            if (num < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            // Update maxProd and minProd
            maxProd = Math.max(num, maxProd * num);
            minProd = Math.min(num, minProd * num);

            // Update the result
            result = Math.max(result, maxProd);
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println("Maximum Product Subarray: " + maxProduct(nums)); // Output: 6
    }
}

// Input: nums = [2,3,-2,4]
// Output: 6

/*This program finds the maximum product subarray using a single pass.
Because negative numbers can flip the sign of a product, I track both the maximum and minimum product ending at each index.
When I see a negative number, the max and min swap roles.
At each step, I update the current max product and keep the global maximum.
This gives the result in one pass.”

Time & Space Complexity

Time: O(n)
Space: O(1) */
