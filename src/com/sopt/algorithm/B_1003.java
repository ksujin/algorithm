package com.sopt.algorithm;

import java.util.Scanner;

public class B_1003 {
    //0이 출력 되는 횟수와 1 이 출력되는 횟수
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int inputCount = scn.nextInt();

        int[] fibonacciZero = new int[42];
        int[] fibonacciOne = new int[42];
        fibonacciZero[0] = 1;
        fibonacciOne[0] = 0;
        //fibonacci[1]이 0을 포함하고 있는 개수
        fibonacciZero[1] =0;
        fibonacciOne[1] = 1;

        for (int i = 2; i < 41; i++) {
            fibonacciZero[i] = fibonacciZero[i-1] + fibonacciZero[i-2];
            fibonacciOne[i] = fibonacciOne[i-1] + fibonacciOne[i-2];
        }

        for (int i = 0; i < inputCount; i++) {
            int inputNum = scn.nextInt();
            System.out.println(fibonacciZero[inputNum]+" "+fibonacciOne[inputNum]);
            //System.out.println(fibonacciOne[inputNum]);

        }

    }

}
