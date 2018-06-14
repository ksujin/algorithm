package com.sopt.algorithm;

import java.util.Scanner;

public class B_2167 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int column = scn.nextInt();
        int inputArray[][] = new int[row+1][column+1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                inputArray[i][j] = scn.nextInt();
            }
        }


        int inputCount = scn.nextInt();
        for (int a = 0; a <inputCount ; a++) {
            int result = 0;
            int i = scn.nextInt();
            int j = scn.nextInt();
            int x = scn.nextInt();
            int y = scn.nextInt();

            for (int k = j; k <= y ; k++) {
                for (int l = i; l <= x; l++) {
                    result += inputArray[l][k];
                }
            }
            System.out.println(result);

        }
    }
}
