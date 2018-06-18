package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_10610 {
    //모든 자리수의 합이 3의 배수이면 3의 배수
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char inputArr[] = br.readLine().toCharArray();
        Arrays.sort(inputArr);

        if(inputArr[0] != '0') {System.out.println(-1); return;}

        int total = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = inputArr.length-1; i >= 0; i--) {
            total += Integer.valueOf(inputArr[i]);
            sb.append(inputArr[i]);
        }

        if (!(total%3==0)){
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }

    }
}
