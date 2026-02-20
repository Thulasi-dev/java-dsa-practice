/*next_permutation : find next lexicographically greater permutation

Given an array Arr[] of integers, rearrange the numbers of the given array 
into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange to the lowest possible
 order (i.e., sorted in ascending order).

*/

public class NextPermutation {

    public static void nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 2;

        // Step 1: find break point
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // Step 2: if break point exists
        if (i >= 0) {
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }

        // Step 3: reverse suffix
        reverse(arr, i + 1, n - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        nextPermutation(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

/* Output: [2,1,3]
 Time : O(n)
 Space: O(1)*/
