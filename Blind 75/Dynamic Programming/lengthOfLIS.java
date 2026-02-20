/*Given an integer array nums, return the length of the longest strictly increasing subsequence.*/

public int lengthOfLIS(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;

    for (int num : nums) {
        int left = 0, right = size;

        // Binary search
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (tails[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        tails[left] = num;

        if (left == size) {
            size++;
        }
    }

    return size;
}


/*Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */