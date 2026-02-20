/* Find the union of two sorted arrays.

The union of two arrays can be defined as the common and distinct elements in the two arrays.
NOTE: Elements in the union should be in ascending order.


🔹 Optimal Approach (Two Pointers)

Since both arrays are already sorted, the two-pointer technique is the best choice.

Why this is best?
Time Complexity: O(n + m)
Space Complexity: O(n + m) (for the result)
No extra sorting needed 🚀

🔹 Algorithm Steps

Use two pointers i and j
Compare arr1[i] and arr2[j]
Add the smaller value to the result (if not already added)
If both values are equal → add once and move both pointers
After one array ends, add remaining elements from the other array */

import java.util.*;

public class UnionOfSortedArrays {

    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        ArrayList<Integer> union = new ArrayList<>();

        while (i < arr1.length && j < arr2.length) {

            // Skip duplicates in arr1
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }

            // Skip duplicates in arr2
            if (j > 0 && arr2[j] == arr2[j - 1]) {
                j++;
                continue;
            }

            if (arr1[i] < arr2[j]) {
                union.add(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                union.add(arr2[j]);
                j++;
            } else {
                // Both are equal
                union.add(arr1[i]);
                i++;
                j++;
            }
        }

        // Remaining elements of arr1
        while (i < arr1.length) {
            if (i == 0 || arr1[i] != arr1[i - 1]) {
                union.add(arr1[i]);
            }
            i++;
        }

        // Remaining elements of arr2
        while (j < arr2.length) {
            if (j == 0 || arr2[j] != arr2[j - 1]) {
                union.add(arr2[j]);
            }
            j++;
        }

        return union;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 3, 5, 6};

        System.out.println(findUnion(arr1, arr2));
    }
}

// Output: [1, 2, 3, 4, 5, 6]