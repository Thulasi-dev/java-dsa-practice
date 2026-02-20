/* Given an array prices[] of length n, representing the prices of the stocks on different days.The task is to find 
the maximum profitpossible by buying and selling the stocks on different days when at most one transaction is allowed. 
Here one transaction means 1 buy + 1 Sell. If it is not possible to make a profit then return 0.

Note: Stock must be bought before being sold.*/

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0; // No prices given
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // Update minimum price
            if (price < minPrice) {
                minPrice = price;
            }

            // Calculate profit and update maxProfit
            int profit = price - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum Profit: " + maxProfit(prices)); // Output: 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Maximum Profit: " + maxProfit(prices2)); // Output: 0
    }
}
