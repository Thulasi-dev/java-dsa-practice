// Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[]. 

public class CountOccurrences {
    // Function to find the first occurrence of the target
    private static int findFirstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, first = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                first = mid; // Potential first occurrence
                high = mid - 1; // Continue searching in the left half
            } else if (arr[mid] < target) {
                low = mid + 1; // Move to the right half
            } else {
                high = mid - 1; // Move to the left half
            }
        }

        return first;
    }

    // Function to find the last occurrence of the target
    private static int findLastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, last = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                last = mid; // Potential last occurrence
                low = mid + 1; // Continue searching in the right half
            } else if (arr[mid] < target) {
                low = mid + 1; // Move to the right half
            } else {
                high = mid - 1; // Move to the left half
            }
        }

        return last;
    }

    // Function to count occurrences of target in the array
    public static int countOccurrences(int[] arr, int target) {
        int first = findFirstOccurrence(arr, target);
        if (first == -1) {
            return 0; // Target not found
        }

        int last = findLastOccurrence(arr, target);
        return last - first + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 2, 3, 4, 5};
        int target1 = 2;
        System.out.println("Occurrences of " + target1 + ": " + countOccurrences(arr1, target1)); // Output: 3

        int[] arr2 = {1, 1, 1, 1, 1, 1};
        int target2 = 1;
        System.out.println("Occurrences of " + target2 + ": " + countOccurrences(arr2, target2)); // Output: 6

        int[] arr3 = {1, 2, 3, 4, 5};
        int target3 = 6;
        System.out.println("Occurrences of " + target3 + ": " + countOccurrences(arr3, target3)); // Output: 0
    }
}
