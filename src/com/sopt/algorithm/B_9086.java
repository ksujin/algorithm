package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B_9086 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tCase-- > 0){
            String input = br.readLine();
            sb.append(input.charAt(0));
            sb.append(input.charAt(input.length()-1)+"\n");
        }
        System.out.println(sb);
    }
}
