/*Find the number that appears once, and the other numbers twice
Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.
Input Format: arr[] = {2,2,1}
Result: 1
Input Format: arr[] = {4,1,2,1,2}
Result: 4

Why XOR works?

XOR has 3 key properties:
    a ^ a = 0
    a ^ 0 = a
    XOR is commutative & associative

So when you XOR all elements:

    Pairs cancel out (x ^ x = 0)
    Only the single element remains
 */
public class SingleNumber {

    public static int findSingle(int[] arr) {
        int result = 0;

        for (int num : arr) {
            result ^= num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        System.out.println(findSingle(arr));
    }
}

/*XOR cancels duplicate numbers because a number XOR with itself becomes zero,
 so the unique number remains. 
 
 Time: O(n)
 Space: O(1) */
