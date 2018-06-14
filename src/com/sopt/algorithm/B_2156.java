/*package com.sopt.algorithm;

import java.util.Scanner;

public class B_2156 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int wineCount = scn.nextInt();
        int wineArray[] = new int[wineCount+2];
        int dp[] = new int[wineCount+2];

        for (int i = 1; i < wineCount+1; i++) {
            wineArray[i] = scn.nextInt();
        }

        //n번째 포도주일때 경우의 수는 3가지로 나뉨
        //1. n번째 포도주 연속으로 0잔 마실때 (즉, 마시지 않을 때)  ->  dp[n] = dp[n-1]
        //2. n번째 포도주를 연속으로 1잔 마실때 -> dp[n] = dp[n-2] + wineArray[n]
        //3. n번째 포도주를 연속으로 2잔 마실때 -> dp[n] = dp[n-3] + wineArray[n-1] + wineArray[n]
        //저 셋중에 max 가 되는것이 n 번째 포도주에서 가장 많이 마실 수 있는 값

        //baseCase
        dp[0] = 0;
        dp[1] = wineArray[1];
        dp[2] = wineArray[1]+wineArray[2];

        for (int i = 3; i <= wineCount; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+wineArray[i], dp[i-3]+wineArray[i-1]+wineArray[i]));
        }
        System.out.println(dp[wineCount]);
    }
}*/
