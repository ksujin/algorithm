package com.sopt.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B_14425 {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        String[] secondArr = new String[m];
        Map<String, Boolean> fisrtMap = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            fisrtMap.put(scn.next(), true);
        }
        for (int i = 0; i < m; i++) {
            String input = scn.next();
            if (fisrtMap.containsKey(input)){
                ans++;
            }
        }
        System.out.println(ans);

    }
}
