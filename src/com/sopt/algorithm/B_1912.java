/*package com.sopt.algorithm;

import java.util.Scanner;

public class B_1912 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int inputCount = scn.nextInt();
        int inputArray[] = new int[inputCount+1];
        int dp[] = new int [inputCount+1];

        int maxNum  = -1001;
        dp[0] = 0;
        for (int i = 1; i <= inputCount ; i++) {
            inputArray[i] = scn.nextInt();
            dp[i] = Math.max(inputArray[i], dp[i-1]+inputArray[i]);
            if (dp[i] > maxNum ){
                maxNum = dp[i];
            }
       }
        System.out.println(maxNum);
    }
}*/
