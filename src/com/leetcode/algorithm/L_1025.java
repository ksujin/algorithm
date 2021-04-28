package com.leetcode.algorithm;

public class L_1025 {
    public static void main(String[] args) {
        int n = 3;
        divisorGame(n);
    }

    public static boolean divisorGame(int n) {
        //https://devjun.tistory.com/113
        return (n % 2 == 0);
    }

}
