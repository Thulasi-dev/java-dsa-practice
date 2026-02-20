// Merge two sorted arrays into one sorted array.

/*✅ Case 1: New array allowed (Most straightforward)
⏱ Time: O(n + m)
💾 Space: O(n + m)*/

public class MergeSortedArrays1 {
    public static int[] merge(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[a.length + b.length];

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        // Copy remaining elements
        while (i < a.length) 
            result[k++] = a[i++];
        while (j < b.length) 
            result[k++] = b[j++];

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6};

        int[] merged = merge(a, b);
        for (int num : merged) {
            System.out.print(num + " "); // 1 2 3 4 5 6
        }
    }
}
