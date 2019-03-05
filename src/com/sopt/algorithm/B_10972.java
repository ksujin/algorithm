package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class B_10972 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int s[] = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            s[i] = Integer.valueOf(values[i]);
        }

        if (next_permutation(s)){
            for (int i = 0; i < n; i++) {
                System.out.print(s[i]+" ");
            }
        } else {
            System.out.println(-1);
        }

    }

    public static boolean next_permutation(int[] s){

        int n = s.length;

        //1. A[i-1] < A[i] 이 성립하는 가장 큰 i 를 구한다.
        int i = n-1;
        while(i > 0 && s[i] <= s[i-1]) {
            i--;
        }
        if (i<=0) return false; //마지막

        //2. j >= i 이고, A[i-1] < A[j]이 성립하는 가장 큰 j를 구한다.
        int j = n-1;
        while(s[j] <= s[i-1]){
            //최소는 j==i 가 될 것.
            j--;
        }

        //3. A[i-1] 와 A[j]를 swap 한다.
        int temp = s[i-1];
        s[i-1] = s[j];
        s[j] = temp;

        //4. A[i] 부터 순열을 뒤집는다.
        j = n-1;
        while ( i < j) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }

        return true;
    }

}
