package com.sopt.algorithm;

import java.util.Scanner;

public class B_9465 {
    public static  void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int testCase = scn.nextInt();
        while(testCase > 0){
            int n = scn.nextInt();
            int[][] sticker = new int[n][2];
            int[][] dp = new int[n][2];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    sticker[j][i] = scn.nextInt();
                }
            }

            if(n == 1){
                int ans = Math.max(sticker[0][0], sticker[0][1]);
                System.out.println(ans);
                return;
            } else if (n == 2){
                int ans = Math.max(sticker[0][0] + sticker[1][1], sticker[0][1]+sticker[1][0]);
                System.out.println(ans);
                return;
            }

            dp[0][0] = sticker[0][0];
            dp[0][1] = sticker[0][1];
            dp[1][0] = sticker[1][0] + sticker[0][1];
            dp[1][1] = sticker[1][1] + sticker[0][0];

            for (int i = 2; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    dp[i][j] = Math.max(sticker[i][j]+dp[i-1][(j+1)%2], sticker[i][j]+dp[i-2][(j+1)%2]);
                }

            }

            int ans = Math.max(dp[n-1][0], dp[n-1][1]);
            System.out.println(ans);

            testCase--;
        }
    }
}
