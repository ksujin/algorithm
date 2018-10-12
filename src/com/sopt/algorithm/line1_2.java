package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class line1_2 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.valueOf(br.readLine());
        for (int j = 0; j < inputCount; j++) {
            Queue<String> queue = new LinkedList();
            String[] input = br.readLine().split(" ");
            Stack<String> stack = new Stack();
            for (int i = 0; i < input.length; i++) {
                String current = input[i];
                switch (current){
                    case "(" :
                        stack.push(current);
                        break;
                    case ")" :
                        while (!stack.isEmpty() && !stack.peek().equals("(")) {
                            queue.add(stack.pop());
                        }
                        stack.pop();
                        break;
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        while (!stack.isEmpty()&& priority(stack.peek())>= priority(current)){
                            //stack에서 꺼내서 sb에 append 하려면 현재것보다 stack 에 있는 것이 우선순위가 같거나 커야함
                            queue.add(stack.pop());
                        }
                        stack.push(current);
                        break;
                    default:
                        queue.add(current);
                        break;

                }
            }
            while (!stack.isEmpty()){
                queue.add(stack.pop());
            }

            Stack<Integer> intStack = new Stack<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                switch (current){
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        calculate(intStack, current);
                        break;
                    default:
                        intStack.push(Integer.valueOf(current));
                        break;
                }
            }

            System.out.println(intStack.peek());
        }

    }

    static public void calculate(Stack<Integer> intStack, String operator){
        int a = intStack.pop();
        int b = intStack.pop();
        int temp = 0;
        switch (operator){
            case "+":
                temp = b+a;
                break;
            case "-":
                temp = b-a;
                break;
            case "*":
                temp = b*a;
                break;
            case "/":
                temp = b/a;
                break;
        }
        intStack.push(temp);
    }

    static public int priority(String input){
        switch (input){
            case "(":
            case ")":
                return 0;
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 1;
        }
    }
}
