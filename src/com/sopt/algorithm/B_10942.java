package com.sopt.algorithm;

import java.util.Scanner;
/*
* 왼쪽 끝과 오른쪽 끝이 같다면, 그 사이의 숫자가 팰린드롬이라면, 이 숫자는 팰린드롬이 된다.
하나하나 이동하면서 비교할 필요가 없고, 그 사이의 수가 팰린드롬인지 판단하면 된다.

dp[s][e] = s부터 e까지 팰린드롬인지 아닌지
dp[s][e] = array[s] == array[e] && dp[s + 1][e - 1]

출처: http://mygumi.tistory.com/176 [마이구미의 HelloWorld]
* */
public class B_10942 {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int inputArr[] = new int[n+1];
        boolean dp[][] = new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            inputArr[i] = scn.nextInt();
        }


        //i는 s
        for (int i = 1; i <= n ; i++) {
            //길이가 1일때 무조건 팰린드롬
            dp[i][i] = true;
            //전거랑 다음거랑 같다면 무조건 팰린드롬
            if(inputArr[i] == inputArr[i-1]){
                dp[i-1][i] = true;
            }
        }

        //i는 거리 s에서 e까지 길이. i가 2이면 1,2,3 세개 포함
        for (int i = 2; i <= n-1; i++) {
            // j 부터 j+i 만큼 갈건데 그 j+i 가 n 보다 작거나 같아야함
            // j+i <= n.  따라서 j<= n-i
            for (int j = 1; j <= n-i; j++) {
                dp[j][j+i] = inputArr[j] == inputArr[j+i] && dp[j+1][j+i-1];
            }
        }



        int qCount = scn.nextInt();
        StringBuilder sb = new StringBuilder();
        while (qCount-- > 0){
            int startIdx = scn.nextInt();
            int endIdx = scn.nextInt();
            if(dp[startIdx][endIdx]){
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
            //System.out.println(dp[startIdx][endIdx] ? "1" : "0");

        }
        System.out.println(sb);
    }
}
