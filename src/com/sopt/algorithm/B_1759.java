package com.sopt.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B_1759 {
    static char alphabetArray[];
    static int alphabetCount;
    static int pwdLength;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        pwdLength = scn.nextInt();
        alphabetCount = scn.nextInt();
        int vowelCount = 0;
        alphabetArray = new char[alphabetCount];
        char result[] = new char[pwdLength];

        for (int i = 0; i < alphabetCount; i++) {
            char ascillAlphabet = scn.next().charAt(0);
            alphabetArray[i] = ascillAlphabet;
        }
        //정렬
        Arrays.sort(alphabetArray);

        backTracking(0, "", 0, 0);


    }

    private static void backTracking(int pos, String str,int ja, int mo){
        if (str.length() == pwdLength){
            if(ja < 2 || mo < 1){
                return;
            }
            System.out.println(str);
        }

        for (int i = pos; i < alphabetCount; i++) {
            if (alphabetArray[i] == 'a' || alphabetArray[i] == 'e' || alphabetArray[i] == 'i' ||
                    alphabetArray[i] == 'o' || alphabetArray[i] == 'u' ){
                backTracking(i+1, str+alphabetArray[i], ja, mo+1);
            } else {
                backTracking(i+1, str+alphabetArray[i], ja+1, mo);
            }
        }
    }


}

