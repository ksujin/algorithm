package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_11655 {

    // 숫자, => 48~57
    // 대문자, => 65~90
    // 소문, => 97~122
    // 공백 => 32

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            int ascii = Character.valueOf(input.charAt(i));
            if ((65<= ascii && ascii <= 90)){
                int convertedInt = ((ascii-65+13) % 26)+65;
                char converted = (char) (convertedInt);
                sb.append(converted);
            } else if ((97<= ascii && ascii <= 122)){
                int convertedInt = ((ascii-97+13) % 26)+97;
                char converted = (char) (convertedInt);
                sb.append(converted);
            } else {
                sb.append(input.charAt(i));
            }

        }
        System.out.println(sb);

    }
}
