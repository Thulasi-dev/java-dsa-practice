/*1️⃣ Find single duplicate in an array

Constraint (most common in interviews):
Array of size n+1
Numbers in range 1 to n
Only one duplicate, may repeat multiple times

✅ Optimal Solution – Floyd’s Cycle Detection (Tortoise & Hare)
👉 O(n) time, O(1) space*/

public class SingleDuplicate {
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Step 1: Detect cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Step 2: Find entry point of cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(arr)); // 2
    }
}
