/*Total count

You are given an array arr[] of positive integers and a threshold value k. For each element in the array, divide it into the minimum number of small integers such that each divided integer is less than or equal to k. Compute the total number of these integer across all elements of the array.

Problem Understanding

	For each element x in the array:
	You can split x into smaller positive integers
	Each part must be ≤ k
	You want the minimum number of parts
	Finally, sum the number of parts for all elements

*/

class MinSplitCount {

    public static int minCount(int[] arr, int k) {
        int total = 0;

        for (int num : arr) {
            total += (num + k - 1) / k;
        }

        return total;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 8};
        int k = 3;

        System.out.println(minCount(arr, k));
    }
}

/*Time Complexity:
O(n)

Space Complexity:
O(1)

Q: Why greedy works here?
A: Because increasing piece size reduces the number of pieces, and k is the maximum allowed size.

Interview Explanation (Short & Strong)

“To minimize the number of pieces, each piece should be as large as possible, i.e., k.
So for a number x, the minimum parts required is ceil(x / k).
I compute this using integer math and sum it for all elements.”*/