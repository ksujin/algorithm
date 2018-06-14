package com.sopt.algorithm;

import java.util.Scanner;

public class B_2563 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int  inputCount = scn.nextInt();
        int inputArray[][] = new int[101][101];
        int result = 0;

        for (int i = 0; i < inputCount; i++) {
            int x = scn.nextInt();
            int y = scn.nextInt();

            for (int j = x; j <= x+9 ; j++) {
                for (int k = y; k <= y+9; k++) {
                    inputArray[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < 100 ; i++) {
            for (int j = 0; j < 100; j++) {
                result += inputArray[i][j];
            }
        }

        System.out.println(result);


    }
}
