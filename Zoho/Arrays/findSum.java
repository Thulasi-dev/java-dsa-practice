// Sum of two numbers represented as arrays

/*Given two numbers represented by two different arrays, arr1[] and arr2[], the task is to find their sum as a new array. Each array represents a number where each element corresponds to a digit in that number. The resulting sum array should also represent the sum of the two numbers in the same digit-by-digit format.

Note: No leading zeroes in array arr1 and arr2.

Input: arr1[] = [5, 6, 3], arr2[] = [8, 4, 2]
Output: [1, 4, 0, 5]
Explanation: As 563 + 842 = 1405.
*/

import java.util.ArrayList;

class Solution {

    ArrayList<Integer> findSum(int arr1[], int arr2[]) {

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int carry = 0;

        ArrayList<Integer> result = new ArrayList<>();

        while (i >= 0 || j >= 0 || carry != 0) {

            int sum = carry;

            if (i >= 0) 
				sum += arr1[i--];
            if (j >= 0) 
				sum += arr2[j--];

            // Insert at beginning (no reverse needed)
            result.add(0, sum % 10);
            carry = sum / 10;
        }

        return result;
    }
}

/*Complexity

Time Complexity:
O(n²) in worst case
(because add(0, x) shifts elements)

Space Complexity:
O(n) (output)

“To avoid reversing, I insert each computed digit at the front of the ArrayList.
This removes the need for any built-in reverse method and keeps the logic simple.”*/