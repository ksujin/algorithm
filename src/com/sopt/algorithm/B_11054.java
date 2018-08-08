package com.sopt.algorithm;

import java.util.Scanner;

//가장 긴 바이토닉 부분 수열
public class B_11054 {
    public static void main(String args[]){
        new B_11054().solve();
    }

    void solve(){
        Scanner scn = new Scanner(System.in);
        int count = scn.nextInt();
        int max = 0;

        int a[] = new int[count];
        int dp[] = new int[count]; //dp[n]은 n까지 왔을때 가장 큰 부분수열의 길이
        int r_dp[] = new int[count];
        //값 입력
        for (int i = 0; i < count; i++) {
            a[i] = scn.nextInt();

        }


        for (int i = 0; i < count; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
        }


        for (int i = count-1; i >= 0; i--) {
            r_dp[i] = 1;
            for (int j = count-1; j > i; j--) {
                if (a[j] < a[i] && r_dp[j]+1 > r_dp[i]){
                    r_dp[i] = r_dp[j]+1;
                }
            }
        }

        for (int i = 0; i < count; i++) {
            max = max > dp[i]+r_dp[i] ? max : dp[i]+r_dp[i];
        }

        System.out.println(max-1);


    }
}
