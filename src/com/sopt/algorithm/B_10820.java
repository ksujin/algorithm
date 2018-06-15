package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B_10820 {
    // 숫자, => 48~57
    // 대문자, => 65~90
    // 소문, => 97~122
    // 공백 => 32
    //100이하
    /*
    This is String
    SPACE    1    SPACE
     S a M p L e I n P u T
    0L1A2S3T4L5I6N7E8
     */
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (scn.hasNextLine()){
            String input = scn.nextLine();
            int lowerCount = 0, upperCount = 0, intCount = 0, spaceCount = 0;

            for (int i = 0; i < input.length(); i++) {
                int ascii = Character.valueOf(input.charAt(i));

                if(48 <= ascii && ascii<= 57){
                    intCount++;
                } else if (65 <= ascii && ascii<= 90){
                    upperCount++;
                } else if (97 <= ascii && ascii<= 122){
                    lowerCount++;
                } else {
                    spaceCount++;
                }
            }

            System.out.println(lowerCount+" "+upperCount+" "+intCount+" "+spaceCount);
        }




    }
}
