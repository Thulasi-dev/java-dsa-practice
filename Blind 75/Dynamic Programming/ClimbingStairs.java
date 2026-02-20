/*You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 */
public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n <= 2) return n;

        int prev2 = 1; // ways to reach step 1
        int prev1 = 2; // ways to reach step 2

        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5)); // Output: 8
    }
}

