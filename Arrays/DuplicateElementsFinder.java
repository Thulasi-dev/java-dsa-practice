// Given an array arr of integers, find all the elements that occur more than once in the array. 
// If no element repeats, return an empty array.

// Company Tags
// Paytm    Zoho    Flipkart    Amazon    D-E-Shaw    Qualcomm

import java.util.*;

public class DuplicateElementsFinder {
    public static List<Integer> findDuplicates(int[] arr) {
        // To store the count of each element
        Map<Integer, Integer> elementCount = new HashMap<>();
        
        // Iterate through the array and count occurrences
        for (int num : arr) {
            elementCount.put(num, elementCount.getOrDefault(num, 0) + 1);
        }
        
        // Create a list to store the result
        List<Integer> duplicates = new ArrayList<>();
        
        // Find all elements with a count greater than 1
        for (Map.Entry<Integer, Integer> entry : elementCount.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        
        return duplicates;
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = {4, 5, 6, 7, 4, 9, 5};
        List<Integer> result = findDuplicates(arr);
        System.out.println("Duplicate elements: " + result);
        
        int[] noDuplicates = {1, 2, 3, 4, 5};
        List<Integer> emptyResult = findDuplicates(noDuplicates);
        System.out.println("Duplicate elements: " + emptyResult);
    }
}
