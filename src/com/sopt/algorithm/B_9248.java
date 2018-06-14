package com.sopt.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B_9248 {
    static Scanner scn = new Scanner(System.in);
    public static void main(String args[]){

        String inputString = scn.nextLine();
        int inputLength = inputString.length();
        String[] suffixArr = new String[inputLength];
        Map<String, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < inputLength; i++) {
            String tempSuffix = inputString.substring(i, inputLength);
            suffixArr[i] = tempSuffix;
            tempMap.put(tempSuffix, i+1);
        }

        Arrays.sort(suffixArr);

        for (int i = 0; i < suffixArr.length; i++) {
            String sortTemp = suffixArr[i];
            int num = tempMap.get(sortTemp);

            System.out.print(num + " ");
        }

        System.out.println();


        for (int i = 0; i < suffixArr.length; i++) {
            if (i == 0) {

                System.out.print("x ");
                continue;
            }
            char[] prev = suffixArr[i - 1].toCharArray();
            char[] now = suffixArr[i].toCharArray();
            int prevLength = suffixArr[i - 1].length();
            int nowLength = suffixArr[i].length();
            int minLength = Math.min(prevLength, nowLength);

            int tempNum = 0;

            for (int j = 0; j < minLength; j++) {

                if (prev[j] == now[j]) {
                    tempNum++;
                    if(j == minLength-1) System.out.print(tempNum + " ");
                } else {
                    System.out.print(tempNum + " ");
                    break;
                }
            }


        }

    }
}
