package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_1874 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int inputArr[] = new int[count];
        int arr[] = new int[count];
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            inputArr[i] = Integer.parseInt(br.readLine());
            arr[i] = i+1;
        }

        Stack<Integer> stack = new Stack<>();
        int pre = 0;
        int current = 0;
        for (int i = 0; i < count; i++) {
            if (i == 0){
                int first = inputArr[0];
                for (int j = 0; j < first; j++) {
                    stack.push(arr[j]);
                    sb.append("+ ");
                }
                index = first;
                stack.pop();
                sb.append("- ");
            } else {
                pre = inputArr[i-1];
                current = inputArr[i];
                if(pre>current){
                    if (current == stack.pop()){
                        sb.append("- ");
                        continue;
                    } else {
                        System.out.println("NO");
                        return;
                    }
                } else {
                    for (int j = index; j < current; j++) {
                        stack.push(arr[j]);
                        sb.append("+ ");
                    }
                    index = current;
                    stack.pop();
                    sb.append("- ");
                }
            }
        }

        System.out.println(sb);
    }
}
