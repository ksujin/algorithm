package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class B_11656 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String inputArr[] = new String[input.length()];

        for (int i = 0; i < input.length(); i++) {
            inputArr[i] = input.substring(i);
        }

        Arrays.sort(inputArr);

        for (int i = 0; i < input.length(); i++) {
            System.out.println(inputArr[i]);
        }

    }
}
