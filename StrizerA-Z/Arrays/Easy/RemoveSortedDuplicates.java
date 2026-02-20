/*3️⃣ Remove duplicates from sorted array (in-place)
✅ Optimal Two Pointer Approach
👉 O(n) time, O(1) space*/

public class RemoveSortedDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int index = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3};
        int len = removeDuplicates(arr);

        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// input ={1,1,2,2,3}
// Output: 1 2 3
