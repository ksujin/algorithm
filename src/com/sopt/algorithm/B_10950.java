package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10950 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.valueOf(br.readLine());
        while (testCase-- > 0){
            String[] arr = br.readLine().split(" ");
            System.out.println(Integer.valueOf(arr[0])+Integer.valueOf(arr[1]));
        }
    }
}
