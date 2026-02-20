// Smallest greater elements in whole array

/*Given an array A of N length. We need to calculate the next smallest greater element for each element in a given array. If the next greater element is not available in a given array then we need to fill -10000000 at that index place.

*/

import java.util.TreeSet;

public class Solution {

    public static int[] greaterElement(int arr[], int n) {
        int[] result = new int[n];
        TreeSet<Integer> set = new TreeSet<>();

        // Add all elements to TreeSet
        for (int num : arr) {
            set.add(num);
        }

        for (int i = 0; i < n; i++) {
            Integer next = set.higher(arr[i]); // next smallest greater element
            if (next != null) {
                result[i] = next;
            } else {
                result[i] = -10000000;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {13, 6, 7, 12};
        int[] res = greaterElement(arr, arr.length);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}

/*Input : arr[] = {13, 6, 7, 12}
Output : _ 7 12 13 
Explanation:
Here, at index 0, 13 is the greatest value 
in given array and no other array element 
is greater from 13. So at index 0 we fill 
'-10000000'.

Expected Time Complexity: O(N*LOG(N)).
Expected Auxiliary Space: O(N).

*/