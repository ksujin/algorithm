package com.sopt.algorithm;

import java.util.Scanner;
import java.util.Stack;

///()(((()())(())()))(())
public class B_10799 {

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        String temp = scn.next();
        String[] arr = temp.split("");
        Stack<String> stack = new Stack<>();
        int splitCount = 0;
        int sCount = 0;
        boolean open = false;

        for (int i = arr.length-1; i >= 0 ; i--) {
            stack.push(arr[i]);
        }

        //() 이면 잘린 수는 막대 수만큼 더해짐
        //(( 이면 막대 수가 +1 쌓임
        //)) 이면 막대 수 -1 되고, 잘린 수 +1 됨
        //)( 이면 일단 넘어감
        while (!stack.isEmpty()){
          //  System.out.println("a");
            String top = stack.pop();
            if (top.equals("(")){
                if (open == false) {
                    open = true;
                } else {
                    sCount++;
                    open = true;
                }
            } else if (top.equals(")")){
                if (open == false) {
                    sCount--;
                    splitCount++;
                    open = false;
                } else {
                    splitCount += sCount;
                    open = false;
                }
            }

        }

        System.out.println(splitCount);

    }

}
