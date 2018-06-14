/*package com.sopt.algorithm;

import java.util.Scanner;

public class B_2579 {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int stairCount = scn.nextInt();
        int stairArray[] = new int[stairCount+2];
        int dp[] = new int[stairCount+2];
        for (int i = 1; i <= stairCount; i++) {
            stairArray[i]  = scn.nextInt();
        }

        dp[1] = stairArray[1];
        dp[2] = stairArray[1]+stairArray[2];

        //n번째 계단일때 경우의 수는 2가지로 나뉨
        //1. n번째 계단을 연속으로 1칸 오를 때 -> dp[n] = dp[n-2] + wineArray[n]
        //2. n번째 계단을 연속으로 1칸 오를 때 -> dp[n] = dp[n-3] + wineArray[n-1] + wineArray[n]
        //이 둘중에 max 가 되는것이 n 번째 계단에서 가장 많이 올라온 값

        for (int i = 3; i <= stairCount; i++) {
            dp[i] = Math.max(dp[i-2]+stairArray[i], dp[i-3]+stairArray[i-1]+stairArray[i]);

        }

        System.out.println(dp[stairCount]);
    }

}*/
