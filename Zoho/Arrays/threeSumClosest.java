// 3 Sum Closest

/*Given an array arr[] and an integer target, the task is to find the sum of three integers in arr[] such that the sum is closest to target. 

Note: If multiple sums are closest to target, return the maximum one.

Key Idea

	Sort the array
	Fix one element i
	Use two pointers (left, right) to find best sum
	Track:
		Minimum difference from target
		Best sum (handle tie by choosing max)*/
		
import java.util.Arrays;

class Solution {

    public static int threeSumClosest(int[] arr, int target) {

        int n = arr.length;
        Arrays.sort(arr);

        int closestSum = arr[0] + arr[1] + arr[2];
        int minDiff = Math.abs(closestSum - target);

        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int sum = arr[i] + arr[left] + arr[right];
                int diff = Math.abs(sum - target);

                // Update closest sum
                if (diff < minDiff || (diff == minDiff && sum > closestSum)) {
                    minDiff = diff;
                    closestSum = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    // Exact match is best possible
                    return sum;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 2, 1, -4};
        int target = 1;

        System.out.println(threeSumClosest(arr, target));
    }
}

/*Sorted → [-4, -1, 1, 2]

Possible sums:
-4 + -1 + 2 = -3
-1 + 1 + 2 = 2  ← closest (diff = 1)

Answer → 2

Time Complexity:
O(n²)
(sorting O(n log n) + two-pointer traversal)

Space Complexity:
O(1) (ignoring sorting space)

Interview Explanation (Short & Strong)

“I sort the array and fix one element.
Using two pointers, I adjust the sum towards the target.
I track the closest difference, and if two sums are equally close, I choose the larger sum as required.”

Important Interview Edge Case

Why sorting is needed?
→ It enables efficient two-pointer movement to approach the target optimally.*/