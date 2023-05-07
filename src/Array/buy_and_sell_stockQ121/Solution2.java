package Array.buy_and_sell_stockQ121;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing
 * a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 */
public class Solution2 {

    /** This solution uses pointer to find the max profit. Initially left pointer is at the first element
     *  and right pointer is at the second element. If the right pointer is greater than the left pointer,
     *  calculate the profit and update the max profit. If the right pointer is less than the left pointer,
     *  update the left pointer to the right pointer. Repeat the process until the right pointer reaches
     *  the end of the array.
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        // initiate returning profit
        int profit = 0;
        // initiate buy and sell
        int buy = prices[0];

        // use recursion to find the max profit
        // loop through price array from the end
        for (int i = 1; i < prices.length; i++) {
            // if current price is less than buy, update buy
            if (prices[i] < buy) {
                buy = prices[i];
            }
            // if current price is greater than buy, calculate profit
            if (prices[i] > buy) {
                profit = Math.max(profit, prices[i] - buy);
            }
        }
        return profit;
    }

}
