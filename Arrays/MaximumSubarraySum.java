// Company Tags
// Zoho    Flipkart    Morgan Stanley    Accolite    Amazon    Microsoft    Samsung    Snapdeal    24*7 Innovation Labs  Payu
//Citrix    D-E-Shaw    FactSet    Hike   Housing.com    MetLife    Ola Cabs    Oracle  Teradata  Visa  Walmart  Adobe  Google  Arcesium

// Kadane's Algorithm
// Given an integer array arr[]. You need to find the maximum sum of a subarray.

public class MaximumSubarraySum {
    public static int maxSubarraySum(int arr[]) {
        // Initialize variables
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        // Iterate through the array
        for (int num : arr) {
            // Update the current sum
            currentSum = Math.max(num, currentSum + num);

            // Update the maximum sum if needed
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        // Example input
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        // Find and print the maximum sum of a subarray
        int maxSum = maxSubarraySum(arr);
        System.out.println("The maximum sum of a subarray is: " + maxSum);
    }
}

// Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
// Output: 11
// Explanation: The subarray {7, -1, 2, 3} has the largest sum 11.
