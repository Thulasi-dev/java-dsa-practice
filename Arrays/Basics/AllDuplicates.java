/*2️⃣ Find all duplicates in an array (multiple duplicates)

Constraint:
Values in range 1 to n
Each element appears once or twice

✅ Optimal Solution – Index Marking Technique
👉 O(n) time, O(1) extra space

🔹 Key idea:
Use array indices as markers
Negative value means already visited */

import java.util.*;

public class AllDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                result.add(index + 1);
            } else {
                nums[index] = -nums[index];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(arr)); // [2, 3]
    }
}
