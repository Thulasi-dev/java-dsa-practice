public class PerfectSquares {

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];

        // Initialize dp with a large value
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0; // base case

        // Compute dp values
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println("Minimum perfect squares: " + numSquares(n));  // Output: 3 (4 + 4 + 4)

        n = 13;
        System.out.println("Minimum perfect squares: " + numSquares(n));  // Output: 2 (4 + 9)
    }
}
