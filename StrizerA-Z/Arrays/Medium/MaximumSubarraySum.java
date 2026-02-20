// Company Tags
// Zoho    Flipkart    Morgan Stanley    Accolite    Amazon    Microsoft    Samsung    Snapdeal    24*7 Innovation Labs  Payu
//Citrix    D-E-Shaw    FactSet    Hike   Housing.com    MetLife    Ola Cabs    Oracle  Teradata  Visa  Walmart  Adobe  Google  Arcesium

// Kadane's Algorithm
// Given an integer array arr[]. You need to find the maximum sum of a subarray.

public class MaximumSubarraySum {

    public static int maxSubArray(int[] arr) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            // Update maximum sum
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            // If current sum becomes negative, reset it
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr)); // Output: 6
    }
}

// Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
// Output: 11
// Explanation: The subarray {7, -1, 2, 3} has the largest sum 11.

/*Short Interview Explanation

“I use Kadane’s Algorithm.
I iterate through the array while keeping track of the current subarray sum.
If the current sum becomes negative, I reset it to zero because it won’t help future subarrays.
At each step, I update the maximum sum found so far.
This gives the maximum subarray sum in linear time.”

Time & Space Complexity

Time: O(n)
Space: O(1) */