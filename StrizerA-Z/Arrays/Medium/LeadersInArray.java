/*Leaders in an Array

Input: arr = [4, 7, 1, 0]  
Output: 7 1 0 

Time: O(n)
Space: O(n)
 */

import java.util.*;

public class LeadersInArray {

    public static ArrayList<Integer> findLeaders(int[] arr) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int n = arr.length;

        int maxFromRight = arr[n - 1];
        leaders.add(maxFromRight);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i];
                leaders.add(arr[i]);
            }
        }

        // Reverse to maintain order
        //Collections.reverse(leaders);

        // Manual reverse (no inbuilt method)
        int left = 0;
        int right = leaders.size() - 1;

        while (left < right) {
            int temp = leaders.get(left);
            leaders.set(left, leaders.get(right));
            leaders.set(right, temp);
            left++;
            right--;
        }
        return leaders;
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};  // [17, 5, 2]
        System.out.println(findLeaders(arr));
    }
}

/*Traverse from right, keep max so far, and mark elements
 greater than or equal to it as leaders. */
