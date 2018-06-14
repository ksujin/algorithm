package com.sopt.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B_13322 {
    static Scanner scn = new Scanner(System.in);
    public static void main(String args[]){

        String inputString = scn.nextLine();
        int inputLength = inputString.length();
        String[] prefixArr = new String[inputLength];
        System.out.println(inputLength);

        for (int i = 1; i <= inputLength; i++) {
            String tempPrefix = inputString.substring(0, i);

          //  System.out.println(i-1);
            prefixArr[i-1] = tempPrefix;
           // System.out.println(prefixArr[i-1]);
        }

        Arrays.sort(prefixArr);

        for (int i = 0; i < inputLength; i++) {
            String sortTemp = prefixArr[i];
            System.out.println(sortTemp);
            int num = sortTemp.length();
            System.out.println(num);
        }


    }
}
