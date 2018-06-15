package com.sopt.algorithm;

import java.util.Scanner;

public class B_9084 {

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int testCount = scn.nextInt();
        for (int i = 0; i < testCount; i++) {
            int coinTypeCount = scn.nextInt();
            int coins[] = new int[coinTypeCount];
            for (int j = 0; j < coinTypeCount; j++) {
                coins[j] = scn.nextInt();
            }
            int goal = scn.nextInt();


            int dp[] = new int[goal+1];
            dp[0] = 1;
            for (int j = 0; j < coinTypeCount; j++) {
                for (int k = coins[j]; k <= goal ; k++) {
                    dp[k] = dp[k] + dp[k-coins[j]];
                }
            }
            System.out.println(dp[goal]);

        }
    }
}
