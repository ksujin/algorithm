package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while (true) {
            input = br.readLine();
            if (input.equals("0 0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            System.out.println(a+b);
        }
    }
}
