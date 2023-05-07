package Array.buy_and_sell_stockQ121;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing
 * a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        /**
         * This solution uses pointer to find the max profit.
         * Initially right pointer is at the last element and left pointer is at the second last element.
         * If the left pointer is less than the right pointer, calculate the profit and update the max profit.
         * If the left pointer is greater than the right pointer, update the right pointer to the left pointer.
         * Repeat the process until the left pointer reaches the beginning of the array.
         */

        // initiate returning profit
        int profit = 0;
        // initiate buy and sell
        int sell = prices[prices.length - 1];

        // use recursion to find the max profit
        // loop through price array from the end
        for (int i = prices.length - 1; i >= 0; i--){
            // if current price is greater than sell, update sell
            if (prices[i] > sell){
                sell = prices[i];
            }
            // if current price is less than sell, calculate profit
            if (prices[i] < sell){
                profit = Math.max(profit, sell - prices[i]);
            }
        }
        return profit;
    }

}
