package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1541 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputArr[] = br.readLine().split("-");

        int plusResult = 0;
        String plusArr[] = inputArr[0].split("\\+");
        for(String a : plusArr){
            plusResult += Integer.valueOf(a);
        }

        int minusResult = 0;
        for (int i = 1; i <  inputArr.length; i++) {
            String tempMinusArr[] = inputArr[i].split("\\+");
            for (String a : tempMinusArr) {
                minusResult += Integer.valueOf(a);
            }
        }

        System.out.println(plusResult - minusResult);

    }
}
