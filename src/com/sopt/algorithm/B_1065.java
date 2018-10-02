package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1065 {
    public static void main(String args[]) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        int inputNum = Integer.valueOf(bf.readLine());
        int ans = 0;
        for (int i = 1; i <= inputNum ; i++) {
            String inputArr[] = String.valueOf(i).split("");
            int length = inputArr.length;
            if (length == 1 || length == 2){ans++;}
            else {
                int difference = Integer.valueOf(inputArr[1])-Integer.valueOf(inputArr[0]);
                for (int j = 0; j < length-1; j++) {
                    int difference2 = Integer.valueOf(inputArr[j+1])-Integer.valueOf(inputArr[j]);
                    if (difference == difference2){
                        if (j == length-2){
                            ans++;
                        }
                      continue;
                    } else {
                       break;
                    }
                }
            }
        }
        System.out.println(ans);

    }
}
