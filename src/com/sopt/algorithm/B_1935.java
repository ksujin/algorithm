package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//후위 표기식2
/*
    피연산자는 스택에 push 한다.
    연산자가 나오면 스택에 있는 수를 2번 pop 한다.
    pop한 두 수를 연산자에 맞게 계산한 후, 다시 push 한다.
    모든 계산이 끝나면, 스택의 top이 최종 계산 값이 된다.

    출처: http://mygumi.tistory.com/184 [마이구미의 HelloWorld]
* */
public class B_1935 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.valueOf(br.readLine());
        char[] input = br.readLine().toCharArray();
        double[] inputInt = new double[inputCount];
        StringBuilder sb = new StringBuilder();

        //숫자 입력 받음
        for (int i = 0; i < inputCount; i++) {
            //inputInt[0]은 A, inputInt[1]은 B에 대응
            inputInt[i] = Integer.valueOf(br.readLine());
        }

        Stack<Double> stack = new Stack<>();


        for (int i = 0; i < input.length; i++) {
            char temp = input[i];
            switch (temp) {
                case '+':
                case '-':
                case '*':
                case '/':
                    cal(stack, stack.pop(), stack.pop(), temp);
                    break;
                default:
                    stack.push(inputInt[temp-'A']);
                    break;
            }
        }

        System.out.format("%.2f", stack.peek());
    }

    public static void cal(Stack<Double> stack, double a, double b, char op){
        switch (op){
            case '+':
                stack.push(b+a);
                break;
            case '-':
                stack.push(b-a);
                break;
            case '*':
                stack.push(b*a);
                break;
            case '/':
                stack.push(b/a);
                break;
                default:
                    break;
        }
    }
}

