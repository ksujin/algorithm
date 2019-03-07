package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1001 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int a = Integer.valueOf(line[0]);
        int b = Integer.valueOf(line[1]);
        System.out.println(a-b);
    }
}
