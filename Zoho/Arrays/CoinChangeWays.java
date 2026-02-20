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


---------------------------------------------------------

// Coin Change (Count Ways)
/*Given an integer array coins[ ] representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ]. 
Note: Assume that you have an infinite supply of each type of coin. Therefore, you can use any coin as many times as you want.
Answers are guaranteed to fit into a 32-bit integer. 

Input: coins[] = [1, 2, 3], sum = 4
Output: 4
Explanation: Four Possible ways are: [1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3].
 */

public static int coinChangeWays(int[] coins, int sum) {
		int n=coins.length;
		int[] dp= new int[sum+1];
		dp[0]=1;
		for(int coin:coins) {
			for(int i=coin;i<=sum;i++) {
				dp[i]+=dp[i-coin];
			}
		}
		return dp[sum];
	}

public static void main(String[] args){
    int[] coins= {1,2,5};
    int sum=5;
    System.out.println("Coint Change ways: "+coinChangeWays(coins, sum));
}

// output: 4 --> [1,1,1,1,1], [1,1,1,2],[2,2,1], [5]

