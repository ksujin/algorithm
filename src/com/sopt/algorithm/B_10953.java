package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(",");
            int a = Integer.valueOf(input[0]);
            int b = Integer.valueOf(input[1]);
            System.out.println(a+b);
        }
    }
}
