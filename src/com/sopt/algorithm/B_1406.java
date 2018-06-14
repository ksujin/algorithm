package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_1406 {
    public static void main(String args[]) throws IOException{

        Stack<Character> stack = new Stack<>();
        Stack<Character> stack_R = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 기존 문자열 입력받기
        String def= br.readLine();


        for (int i = 0; i < def.length(); i++) {
            stack.push(def.charAt(i));
        }

        int inputCount = Integer.parseInt(br.readLine());

     //   int current = def.length();
        for (int i = 0; i < inputCount; i++) {
            String arr = br.readLine();
            if (arr.equals("L")){
                if(stack.size() > 0){
                    stack_R.push(stack.pop());
                }

            } else if (arr.equals("D")){
                if(stack_R.size() > 0){
                    stack.push(stack_R.pop());
                }

            } else if (arr.equals("B")){
                if(stack.size() > 0){
                    stack.pop();
                }

            } else if (arr.contains("P")){
                stack.push(arr.charAt(2));
            }

        }



        while(!stack.isEmpty()){
            stack_R.push(stack.pop());
        }

        StringBuilder sb = new StringBuilder();

       while(!stack_R.isEmpty()){
           sb.append(stack_R.pop());
       }

        System.out.println(sb);

    }
}
