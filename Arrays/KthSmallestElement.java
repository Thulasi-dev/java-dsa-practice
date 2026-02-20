public class KthSmallestElement {

    // Function to partition the array around the pivot
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i + 1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Function to implement QuickSelect
    private static int quickSelect(int[] arr, int low, int high, int k) {
        if (low <= high) {
            // Partition the array
            int partitionIndex = partition(arr, low, high);

            // If partition index is the k-th element, return the element
            if (partitionIndex == k) {
                return arr[partitionIndex];
            } else if (partitionIndex > k) {
                // If k is less, search the left part
                return quickSelect(arr, low, partitionIndex - 1, k);
            } else {
                // If k is more, search the right part
                return quickSelect(arr, partitionIndex + 1, high, k);
            }
        }
        return Integer.MAX_VALUE;
    }

    // Function to find the k-th smallest element
    public static int findKthSmallest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 19};
        int k = 2;
        System.out.println("K-th smallest element is " + findKthSmallest(arr, k)); // Output: 5
    }
}
