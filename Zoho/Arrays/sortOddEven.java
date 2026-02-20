// Sort in specific order

/*Given an array arr[] of positive integers. Your have to sort them so that the first part of the array contains odd numbers sorted in descending order, and the rest of the portion contains even numbers sorted in ascending order.

Input: arr[] = [1, 2, 3, 5, 4, 7, 10]
Output: [7, 5, 3, 1, 2, 4, 10]
Explanation: 7, 5, 3, 1 are odd numbers in descending order and 2, 4, 10 are even numbers in ascending order.
*/

import java.util.Arrays;

class OddEvenSort {

    public static void sortOddEven(int[] arr) {

        int oddCount = 0, evenCount = 0;

        // Count odds and evens
        for (int num : arr) {
            if (num % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }

        int[] odd = new int[oddCount];
        int[] even = new int[evenCount];

        int oi = 0, ei = 0;

        // Separate odds and evens
        for (int num : arr) {
            if (num % 2 == 0)
                even[ei++] = num;
            else
                odd[oi++] = num;
        }

        // Sort arrays
        Arrays.sort(odd);   // ascending
        Arrays.sort(even);  // ascending

        // Merge (odd descending, even ascending)
        int index = 0;

        for (int i = odd.length - 1; i >= 0; i--)
            arr[index++] = odd[i];

        for (int i = 0; i < even.length; i++)
            arr[index++] = even[i];
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 8, 1, 4};
        sortOddEven(arr);
        System.out.println(Arrays.toString(arr)); // output [5, 3, 1, 2, 4, 8]
    }
}

/*Time Complexity:
O(n log n) (due to sorting)

Space Complexity:
O(n) (extra arrays)

Interview Explanation (Crisp)

“I first separate odd and even elements into two arrays.
I sort both arrays using Arrays.sort().
Then I merge odds in reverse order to get descending, followed by evens in ascending order.”*/