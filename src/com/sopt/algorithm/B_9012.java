package com.sopt.algorithm;

import java.util.Scanner;
import java.util.Stack;

public class B_9012 {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int count = scn.nextInt();
        scn.nextLine();

    loop:
        for (int i = 0; i < count; i++) {
           // System.out.println(i);
            Stack<Integer> stack = new Stack();
            String temp = scn.nextLine();
            String[] tempArr = temp.split("");
          //  System.out.println(tempArr.length);
            for (int j = 0; j < tempArr.length; j++) {

                if (tempArr[j].equals("(")) {
                    stack.push(1);
                } else {
                    if (stack.size() == 0 ){
                       // System.out.println(j);
                        System.out.println("NO");
                        continue loop;
                    } else  {
                        stack.pop();
                    }

                }
            }

            if (stack.size() == 0 ) {
                System.out.println("YES");
            } else if (stack.size() > 0){
                System.out.println("NO");
            }
        }
    }
}
