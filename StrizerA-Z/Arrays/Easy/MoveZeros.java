public class MoveZeros {
    public static void moveZerosToEnd(int[] arr) {
        int lastNonZeroFoundAt = 0; // Position to place the next non-zero element

        // Traverse through the array
        for (int i = 0; i < arr.length; i++) {
            // If the current element is non-zero, move it to the lastNonZeroFoundAt position
            if (arr[i] != 0) {
                // Swap elements
                int temp = arr[i];
                arr[i] = arr[lastNonZeroFoundAt];
                arr[lastNonZeroFoundAt] = temp;

                // Increment the lastNonZeroFoundAt index
                lastNonZeroFoundAt++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0, 3, 12};
        moveZerosToEnd(arr1);
        System.out.println("Array after moving zeros: " + java.util.Arrays.toString(arr1)); // Output: [1, 3, 12, 0, 0]

        int[] arr2 = {0, 0, 1};
        moveZerosToEnd(arr2);
        System.out.println("Array after moving zeros: " + java.util.Arrays.toString(arr2)); // Output: [1, 0, 0]

        int[] arr3 = {1, 2, 3};
        moveZerosToEnd(arr3);
        System.out.println("Array after moving zeros: " + java.util.Arrays.toString(arr3)); // Output: [1, 2, 3]
    }
}
