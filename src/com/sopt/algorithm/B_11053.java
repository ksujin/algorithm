package com.sopt.algorithm;

import java.util.Scanner;

/*public class B_11053 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int arrayCount = scn.nextInt();
        int[] numberArray = new int[1000];
        int[] dp = new int[1000];
        int max_length = 0;
        for (int i = 0; i < arrayCount; i++) {
            numberArray[i] = scn.nextInt();
        }

        for (int i = 0; i < arrayCount ; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(numberArray[i] > numberArray[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
            if (max_length < dp[i]){
                max_length = dp[i];
            }
        }

        System.out.println(max_length);
    }
}*/
