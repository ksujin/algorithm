/*package com.sopt.algorithm;

import java.util.Scanner;

public class B_1660 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int inputCount = scn.nextInt();
        int cannonBallArray[] = new int[123];
        int completeCannonBallArray[] = new int[123];
        int dp[] = new int[300001];

        int temp = 0;
        int i = 1;
        while(true){
            cannonBallArray[i] = cannonBallArray[i-1] + i;
            completeCannonBallArray[i] = completeCannonBallArray[i-1] + cannonBallArray[i];
            temp = completeCannonBallArray[i];
            if (temp <= 300000){
                i++;
            } else {
                //30000이 넘을때
                break;
            }
        }


        int max = 300001;
        dp[0] = 0;
        for (int k = 1; k <= inputCount; k++) {
            dp[k] = max;
            for (int j = 1; j <= 121 ; j++) {
                if (k >= completeCannonBallArray[j] && dp[k - completeCannonBallArray[j]] != max) {
                    dp[k] = Math.min(dp[k], dp[k - completeCannonBallArray[j]] + 1);
                }
            }
        }
        System.out.println(dp[inputCount]);


    }
}*/