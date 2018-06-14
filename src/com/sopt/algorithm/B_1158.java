package com.sopt.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class B_1158 {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt()-1;
        int index = 0;

        ArrayList<Integer> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }



        for (int i = 0; i < n; i++) {
            index += m;
            if(index >= arr.size()){
                index %= arr.size();
            }
            sb.append(arr.remove(index)+", ");

        }

        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        System.out.print(sb);





    }
}
