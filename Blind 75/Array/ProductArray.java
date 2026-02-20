// Company Tags
// Flipkart    Morgan Stanley    Accolite    Amazon    Microsoft    D-E-Shaw    Intuit    Opera

// Product array puzzle
// Given an array, arr[] construct a product array, res[] where each element in res[i] is the product of all elements in arr[] except arr[i]. Return this resultant array, res[].

public class ProductArrayExceptSelf {

    public static int[] productExceptSelf(int[] arr) {
        int n = arr.length;

        int[] res = new int[n];

        // Step 1: store left product
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            res[i] = leftProduct;
            leftProduct *= arr[i];
        }

        // Step 2: multiply with right product
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= rightProduct;
            rightProduct *= arr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] res = productExceptSelf(arr);

        for (int x : res) {
            System.out.print(x + " ");
        }
        // Output: 24 12 8 6
    }
}


// Input: arr = {1, 2, 3, 4}
// Output: res = {24, 12, 8, 6}
// For res[0]: 2×3×4=24
// For res[1]: 1×3×4=12
// For res[2]: 1×2×4=8
// For res[3]: 1×2×3=6
