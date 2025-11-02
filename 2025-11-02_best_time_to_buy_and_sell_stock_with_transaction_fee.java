// Problem: Best Time to Buy and Sell Stock with Transaction Fee
// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int hold = -prices[0]; // max profit when holding a stock
        int notHold = 0;       // max profit when not holding a stock

        for (int i = 1; i < n; i++) {
            // If we sell today -> prices[i] + hold - fee
            // If we don't sell -> keep previous notHold
            notHold = Math.max(notHold, hold + prices[i] - fee);

            // If we buy today -> notHold - prices[i]
            // If we don't buy -> keep previous hold
            hold = Math.max(hold, notHold - prices[i]);
        }

        return notHold; // max profit when we end without holding stock
    }
}
