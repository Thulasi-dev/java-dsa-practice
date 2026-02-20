/* Find Minimum in Rotated Sorted Array

 Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the 
  array nums = [0,1,2,4,5,6,7] might become:

 [4,5,6,7,0,1,2] if it was rotated 4 times.
 [0,1,2,4,5,6,7] if it was rotated 7 times.
 Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0],
  a[1], a[2], ..., a[n-2]].

 Given the sorted rotated array nums of unique elements, return the minimum element of this array.

 You must write an algorithm that runs in O(log n) time.*/


class FindMin {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the rightmost,
            // the minimum lies in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise it lies in the left half (including mid)
                right = mid;
            }
        }

        // left == right, pointing to the minimum
        return nums[left];
    }
}


// Input: nums = [3,4,5,1,2]
// Output: 1 -- In the array minimum element was 1
// Explanation: The original array was [1,2,3,4,5] rotated 3 times.

/*Key Logic (What interviewer wants to hear)

One half of the array is always sorted
Compare nums[mid] with nums[right]
Decide which half contains the minimum
No need to scan entire array 

Interview Explanation (Best & Short)

“The array was originally sorted, but then rotated at some pivot.
The minimum element is the only place where the order breaks.
I use binary search to find it in O(log n) time.
At each step, I compare the middle element with the rightmost element.
If mid > right, the minimum lies in the right half; otherwise, it lies in the left half including mid.
I keep shrinking the search space until left equals right, which gives the minimum element.”

Time: O(log n)
Space: O(1)*/