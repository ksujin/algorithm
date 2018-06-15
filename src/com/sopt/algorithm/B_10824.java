package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10824 {
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        String first =  input[0] + input[1];
        String second = input[2] + input[3];
        long ans = Long.valueOf(first) + Long.valueOf(second);

        System.out.println(ans);

    }
}

