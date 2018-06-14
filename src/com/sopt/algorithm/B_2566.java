package com.sopt.algorithm;

import java.util.Scanner;

public class B_2566 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int inputArray[][] = new int[10][10];
        int max = -1;
        int rowResult = 0;
        int columnResult = 0;
        for (int row = 1; row <= 9; row++) {
            for (int column = 1; column <= 9; column++) {
                int inputNum = scn.nextInt();
                inputArray[row][column] = inputNum;
                if (max < inputNum){
                    max = inputNum;
                    rowResult = row;
                    columnResult = column;
                }



            }
        }

        System.out.println(max);
        System.out.println((rowResult)+" "+(columnResult));


    }
}
