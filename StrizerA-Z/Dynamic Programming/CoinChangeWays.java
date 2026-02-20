// Given an integer array coins[ ] representing different denominations of currency and an integer sum, find the number of ways 
// you can make sum by using different combinations from coins[ ]. 
// Note: Assume that you have an infinite supply of each type of coin. Therefore, you can use any coin as many times as you want.
// Answers are guaranteed to fit into a 32-bit integer. 

// Company Tags    Paytm    Flipkart    Morgan Stanley    Accolite    Amazon    Microsoft    OYO Rooms    Samsung    Snapdeal    Zoho

import java.util.Arrays;

public class CoinChangeWays {
    // Function to count the number of ways to make sum using given coins
    public static int countWays(int[] coins, int sum) {
        int n = coins.length;
        int[] dp = new int[sum + 1];

        // Base Case: There is 1 way to make sum 0 (by choosing nothing)
        dp[0] = 1;

        // Process each coin
        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[sum]; // Total number of ways to make 'sum'
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5}; // Coin denominations
        int sum = 5; // Target sum

        System.out.println("Number of ways to make sum " + sum + " is: " + countWays(coins, sum));
    }
}


// Input: coins[] = [1, 2, 3], sum = 4
// Output: 4
// Explanation: Four Possible ways are: [1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3].
