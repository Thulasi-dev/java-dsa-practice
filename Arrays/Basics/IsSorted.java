class IsSorted {
    static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false; // Found a decreasing pair
            }
        }
        return true; // All pairs are sorted
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 3, 2, 4, 5};

        System.out.println(isSorted(arr1)); // true
        System.out.println(isSorted(arr2)); // false
    }
}

/*
Time: O(n) → only one pass through array
Space: O(1) → no extra memory used */
