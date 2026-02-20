// Closest Number
// Company Tag: MicroSoft
/*Given two integers n and m (m != 0). The problem is to find the number closest to n and divisible by m. If there is more than one such number, then output the one having the maximum absolute value.

Input: n = 13, m = 4
Output: 12
Explanation: 12 is the Closest Number to 13 which is divisible by 4.
Input: n = -15, m = 6
Output: -18
Explanation: Both -12 and -18 are closest to -15 and divisible by 6, but -18 has the maximum absolute value. So, output is -18.
*/

public class ClosestNumberAlternative {

    public static int closestNumber(int n, int m) {

        // If already divisible
        if (n % m == 0) {
            return n;
        }

        // Correct floor division for negative numbers too
        int lower = m * Math.floorDiv(n, m);

        // Next multiple
        int higher = lower + m;

        int diffLower = Math.abs(n - lower);
        int diffHigher = Math.abs(n - higher);

        if (diffLower < diffHigher) {
            return lower;
        } else if (diffHigher < diffLower) {
            return higher;
        } else {
            // Tie → choose maximum absolute value
            return (Math.abs(lower) > Math.abs(higher)) ? lower : higher;
        }
    }

    public static void main(String[] args) {
        System.out.println(closestNumber(13, 4));    // 12
        System.out.println(closestNumber(15, 4));    // 16
        System.out.println(closestNumber(-15, 6));   // -18
        System.out.println(closestNumber(-7, 3));    // -9
        System.out.println(closestNumber(7, 3));     // 9
    }
}
