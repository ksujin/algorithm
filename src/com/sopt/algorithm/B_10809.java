package com.sopt.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B_10809 {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
       // System.out.println(input);
        int alpha[] = new int[26];
        Arrays.fill(alpha, input.length());
        //int temp = input.length(); //fill
        for (int i = 0; i < input.length(); i++) {

            int ascii = Character.valueOf(input.charAt(i));
            //지금 저장되어있는 값 (나타난 값)이 현재 값보다 크다면
            if(alpha[ascii-97] > i){
                alpha[ascii-97] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (alpha[i] == input.length()){
                System.out.print("-1 ");
            } else {
                System.out.print(alpha[i]+" ");
            }
        }



    }
}
