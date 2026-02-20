// Given an array arr of distinct integers. Rearrange the array in such a way that the first element is the largest and the second element is the smallest, the third element is the //second largest and the fourth element is the second smallest, and so on.
// Company - Zoho

import java.util.*;

public class AlternateSorting {
    public static ArrayList<Integer> alternateSort(int[] arr) {
        int n = arr.length;
        // Implementing simple selection sort to sort the array
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    // Swap arr[i] and arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0, right = n - 1;
        while (left <= right) {
            if (left != right) {
                result.add(arr[right--]); // Largest element
                result.add(arr[left++]);  // Smallest element
            } else {
                result.add(arr[left]); // Middle element for odd length arrays
                break;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 1, 9, 2, 7, 3, 8};
        System.out.println(alternateSort(arr));
    }
}


Input: arr[] = [7, 1, 2, 3, 4, 5, 6]
Output: [7, 1, 6, 2, 5, 3, 4]
Explanation: The first element is first maximum and second element is first minimum and so on.
