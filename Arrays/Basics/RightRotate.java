import java.util.Arrays;

class RightRotate {

    // Helper method to reverse array from start to end index
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Right rotate array by k positions
    static void rightRotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Important if k > n

        // Step 1: Reverse last k elements
        reverse(arr, n - k, n - 1);

        // Step 2: Reverse first n - k elements
        reverse(arr, 0, n - k - 1);

        // Step 3: Reverse the entire array
        reverse(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;

        rightRotate(arr, k);
        System.out.println(Arrays.toString(arr)); // Output: [2, 3, 4, 5, 1]
    }
}
