/*Given an integer N and an array of size N-1 containing N-1 numbers between 
1 to N. Find the number(between 1 to N), that is not present in the given array..

 */
public class MissingElement {
	
    public static int missingNumber(int arr[]) {
        // The length of the array is n - 1
        int n = arr.length + 1;

        // Calculate the expected sum of numbers from 1 to n
        int totalSum = n * (n + 1) / 2;

        // Calculate the sum of elements in the array
        int arraySum = 0;
        for (int num : arr) {
            arraySum += num;
        }

        // The missing number is the difference between totalSum and arraySum
        return totalSum - arraySum;
    }

    // Function to find the missing number using XOR approach
    public static int missingNumber(int[] a, int N) {
            int xor1 = 0, xor2 = 0;

            // XOR all the elements and numbers from 1 to N-1
            for (int i = 0; i < N - 1; i++) {
                xor2 ^= a[i];        // XOR of array elements
                xor1 ^= (i + 1);     // XOR of numbers from 1 to N-1
            }

            xor1 ^= N; // Include N in the XOR

            // XOR of xor1 and xor2 gives the missing number
            return xor1 ^ xor2;
        }

    public static void main(String[] args) {
        // Example input
        int[] arr = {1, 2, 4, 6, 3, 7, 8}; // Array representing a permutation with one missing element

        // Find and print the missing element
        int missingElement = missingNumber(arr);
        System.out.println("The missing element is: " + missingElement);

        int[] a = {1, 2, 4, 5};
        int N = 5;
        int ans = missingNumber(a, N);
        System.out.println("The missing number is: " + ans);
    }
}
