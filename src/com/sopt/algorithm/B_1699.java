package com.sopt.algorithm;

/*
* 출처 http://blog.naver.com/PostView.nhn?blogId=occidere&logNo=220792326120
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1699 {
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] dp = new int[input+1];


        for (int i = 1; i <= input ; i++) dp[i] = i;

        for (int i = 1; i <= input; i++) {
            //dp[12] = Min(dp[12-3*3]+1, dp[12-2*2]+1)
            for (int j = 1; j*j <= i ; j++) {
                dp[i] = Math.min(dp[i-j*j]+1, dp[i]);
            }
        }

        System.out.println(dp[input]);
    }
}
