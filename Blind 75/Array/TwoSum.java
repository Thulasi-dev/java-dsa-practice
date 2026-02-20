/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.*/

import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the difference and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the difference
            int difference = target - nums[i];

            // Check if the difference is already in the map
            if (map.containsKey(difference)) {
                // Return the indices
                return new int[] { map.get(difference), i };
            }

            // Otherwise, store the current number and its index in the map
            map.put(nums[i], i);
        }

        // If no solution is found, throw an exception
        throw new IllegalArgumentException("No two sum solution");
    }

    // Time: O(n), Space: O(n)


    // example for return type boolean
	boolean twoSum(int arr[], int target) {
        // code here
       HashSet<Integer> seen=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            int diff=target-arr[i];
            if(seen.contains(diff)){
                return true;
            }
           seen.add(arr[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        // Example input
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Call the method and get the result
        int[] result = twoSum(nums, target);

        // Print the result
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
