package Array;

/**
 * @program: java_algo
 * @description: Best Time to Buy and Sell Stock II
 * @author: Ze QIN
 * @create: 2023-09-14 13:27
 **/
public class BestBuyAndSell {

    public static int maxProfit(int[] prices) {
        int l = prices.length;
        int profit = 0;
        for (int i = 1; i < l; i++) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }


    public static void main (String[] args) {
        int[] prices = {1,6,3,4,5};

        int profit = maxProfit(prices);

        System.out.println(profit);
    }
}
