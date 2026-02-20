/*Print N to 1 using Recursion

Problem Description: Given an integer N, write a program to print numbers from N to 1.

Input: N = 4
Output: 4, 3, 2, 1
Explanation: All the numbers from 4 to 1 are printed.
Input: N = 1
Output: 1 
Explanation: This is the base case.

Forward Recursion*/

class Solution {
    // Recursive function to print numbers from current down to 1
    public void printNumbers(int current) {
        // Base case: if current is less than 1, stop recursion
        if (current < 1)
            return;

        // Print current number
        System.out.print(current + " ");

        // Recursive call with next smaller number
        printNumbers(current - 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 10;

        sol.printNumbers(n);
        System.out.println();
    }
}

/*Time Complexity: O(N), we print every number from N to 1 using recursion
Space Complexity: O(N), stack space used for recursive calls.
 */