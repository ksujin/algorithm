package com.sopt.algorithm;

import java.util.Scanner;

public class B_10808 {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        int[] alpha = new int[26];
        String inputArr = scn.nextLine();

        for (int i = 0; i < inputArr.length(); i++) {

            int ascii = Character.valueOf(inputArr.charAt(i));
            alpha[ascii-97] = alpha[ascii-97]+1;
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(alpha[i] + " ");
        }
    }
}
