package com.leetcode.algorithm;

public class L_121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        maxProfit(prices);
    }

    public static int maxProfit(int[] prices) {
        //https://sj602.github.io/2020/04/17/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Leetcode-best-time-to-buy-and-sell-stock-%ED%8C%8C%EC%9D%B4%EC%8D%AC-%ED%92%80%EC%9D%B4/
        int minPrice = 10001;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]); //1. 작은 값을 구해서 (사는 값)
            int currentProfit = prices[i] - minPrice; //2. 현재 이익을 구한다.
            maxProfit = Math.max(currentProfit, maxProfit); //3. 최대 이익을 구한다.
        }
        return maxProfit;
    }
}
