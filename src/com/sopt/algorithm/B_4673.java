package com.sopt.algorithm;

public class B_4673 {
    public static void main(String args[]){
        boolean[] numbers = new boolean[10001];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10001; i++) {
            int nextNum = nextNum(i);
            if ((nextNum) > 10000) {continue;}
            numbers[nextNum] = true;

        }

        for (int i = 0; i < 10001; i++) {
            if(!numbers[i]){
                sb.append(i+"\n");
            }
        }
        System.out.println(sb);
    }


    public static int nextNum(int n){
        int ans = n;
        while (n > 0){
            int temp = n % 10;
            ans += temp;
            n = n / 10;
        }
        return ans;
    }
}
