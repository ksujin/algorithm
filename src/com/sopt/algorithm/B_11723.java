package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_11723 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.valueOf(br.readLine());
        int S = 0;
        StringBuilder sb = new StringBuilder();
        while(testCount >0){
            String[] line = br.readLine().split(" ");
            String command = line[0];
            switch (command) {
                case "check" :
                    int checkValue = Integer.valueOf(line[1]);
                    //sb 안쓰고 바로 출력하면 시간초과
                    if((S&(1<<checkValue))==0){
                        sb.append("0\n");
                    } else {
                        sb.append("1\n");
                    }
                    break;
                case "add" :
                    int addValue = Integer.valueOf(line[1]);
                    S = S|(1<<addValue);
                    break;
                case "remove" :
                    int removeValue = Integer.valueOf(line[1]);
                    S = S&~(1<<removeValue);
                    break;
                case "toggle" :
                    int toggleValue = Integer.valueOf(line[1]);
                    S = S^(1<<toggleValue);
                    break;
                case "all" :
                    S = (1<<21)-2;
                    break;
                case "empty" :
                    S = 0;
                    break;
                    default:
                        break;
            }
            testCount--;
        }
        System.out.println(sb);
    }
}
