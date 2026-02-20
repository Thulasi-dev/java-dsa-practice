/*Reverse a given Array
 You are given an array. The task is to reverse the array and print it.*/

import java.util.Arrays;

class ArrReverse {

    static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 2, 9, 1};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
}

/*Time Complexity: O(n) Where n is the number of elements in the array. Each element is visited at most once due to the two-pointer approach.
Space Complexity: O(1) No extra space is used other than a few pointers and variables. The array is reversed in-place.

 */
