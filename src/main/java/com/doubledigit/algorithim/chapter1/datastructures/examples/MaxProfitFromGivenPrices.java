package com.doubledigit.algorithim.chapter1.datastructures.examples;


//input: [20, 10, 50, 30, 60, 80, 10], output: 90
public class MaxProfitFromGivenPrices {

    private static final int[] PRICES = {600, 600, 500, 300, 60, 800, 10};
//    private static final int[] PRICES = {10, 40, 30, 20, 10, 5, 3};

    public static void main(String[] args) {

        int maxProfit = getMaxProfit(PRICES);
        System.out.println("maxProfit = " + maxProfit);

    }

    private static int getMaxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int n = prices.length;
        int finalProfit = 0;

        int i = 0;
        while (i < n - 1) {

            while ((i < n - 1) && (prices[i + 1] <= prices[i])) {
                i++;
            }
            if (i == n - 1) {
                break;
            }
            int buyPrice = prices[i];
            i++;

            while ((i < n - 1) && (prices[i + 1] >= prices[i])) {
                i++;
            }

            int sellPrice = prices[i];
            i++;

            finalProfit = (finalProfit + Math.abs(buyPrice - sellPrice));
        }
        return finalProfit;
    }
}
