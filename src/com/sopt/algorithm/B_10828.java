package com.sopt.algorithm;

import java.util.Scanner;
import java.util.Stack;

public class B_10828 {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int count = scn.nextInt();
        scn.nextLine();
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < count; i++) {
           // System.out.println("i : "+i);
            String temp = scn.nextLine();
            String tempArr[] = temp.split(" ");
          //  System.out.println(tempArr[0]);
            //System.out.println(tempArr[1]);
            switch (tempArr[0]) {
                case "push" :
                    stack.push(Integer.parseInt(tempArr[1]));
                    break;
                case "pop":
                    if (stack.isEmpty()) {System.out.println(-1);} else System.out.println(stack.pop());
                    break;
                case "size" :
                    System.out.println(stack.size());
                    break;
                case "empty" :
                    if (stack.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "top" :
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.peek());
                    }
                    break;
            }
        }
    }
}
