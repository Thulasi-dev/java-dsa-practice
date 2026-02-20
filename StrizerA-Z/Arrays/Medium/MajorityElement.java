// Given an array arr. Find the majority element in the array. If no majority exists, return -1.

// A majority element in an array is an element that appears strictly more than arr.size()/2 times in the array.

import java.util.HashMap;

public class MajorityElement {
    public static int findMajorityElement(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> elementCount = new HashMap<>();

        // Count the occurrences of each element
        for (int num : arr) {
            elementCount.put(num, elementCount.getOrDefault(num, 0) + 1);
        }

        // Check if any element has a count greater than n / 2
        for (int key : elementCount.keySet()) {
            if (elementCount.get(key) > n / 2) {
                return key;
            }
        }

        // If no majority element exists, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 2, 2, 2};
        int result = findMajorityElement(arr);

        if (result != -1) {
            System.out.println("Majority element is: " + result);
        } else {
            System.out.println("No majority element exists.");
        }
    }
}
