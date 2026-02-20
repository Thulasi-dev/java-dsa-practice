/*You are given an integer array coins representing coins of different denominations and
 an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount 
of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 Company Tags    Paytm    Flipkart    Morgan Stanley    Accolite    Amazon   
  Microsoft    OYO Rooms    Samsung    Snapdeal    Zoho*/

class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        // Initialize with large value
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        dp[0] = 0;

        // Build dp array
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}


/*Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Complexity (Must Say in Interview)

Time Complexity: O(amount × number of coins)
Space Complexity: O(amount)

🗣️ One-Line Interview Explanation

“I used dynamic programming where dp[i] stores the minimum coins needed to make amount i. 
For each amount, I try all coins and update dp[i] using dp[i − coin] + 1. 
Finally, if dp[amount] is unreachable, I return -1.”*/

