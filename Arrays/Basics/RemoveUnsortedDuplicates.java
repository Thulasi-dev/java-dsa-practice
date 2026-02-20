/*4️⃣ Remove duplicates from unsorted array
✅ Best Interview-Friendly Solution – HashSet
👉 O(n) time, O(n) space*/

import java.util.*;

public class RemoveUnsortedDuplicates {
    public static int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int index = 0;

        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                nums[index++] = num;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 4, 2, 5, 1};
        int len = removeDuplicates(arr);

        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        // Output: 4 5 2 1
    }
}
