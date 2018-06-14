/*package com.sopt.algorithm;

import java.util.Scanner;

public class B_2193 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int inputNum = scn.nextInt();
        long dp[] = new long[inputNum+1];

        dp[0] = 0;
        dp[1] = 1;

        //0으로 끝나는 것 -> dp[i-1] 경우의 수
        //1로 끝나는 것 01 -> dp[i-2] 경우의 수
        for (int i = 2; i <= inputNum ; i++) {
            dp[i] =  dp[i-1] + dp[i-2];
        }
        System.out.println(dp[inputNum]);
    }
}*/
