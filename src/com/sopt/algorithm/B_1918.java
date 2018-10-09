package com.sopt.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//후위 표기식
public class B_1918 {

    /*
    * 피연산자(a,b,c)는 출력한다.
    연산자는 앞 연산자(스택의 맨 위)를 살펴서 출력하거나 대기한다(스택에 넣는다, 대기 된 자료들은 나중에 대기 된 연산자가 먼저 나온다, LIFO, 스택을 이용)
    연산자의 대기(스택에 push)여부는 연산자간의 우선순위에 따른다.

    스택에는 연산자만 사용하고, 피연산자는 바로바로 출력한다.

    먼저, 스택의 자료를 위해 연산자에 우선순위를 둔다. '*', '/', '+', '-', '(', ')'
    stack 에 있는것보다 들어오는 것의 우선순위가 클 경우 push 하고(*,/ 같은거 들어오면 stack에 push),
    그렇지 않을 경우, pop한다.
    (우선순위가 같다면, 먼저 스택에 들어온 연산자를 먼저 내보내야하기 때문에 클 경우만 push를 한다.)

    그리고, 알다시피 괄호는 우선적으로 처리해줘야하기 때문에, 괄호가 닫히면 이전 괄호까지 pop을 해준다.
    마지막으로 쌓인 스택을 비워주면 끝
    출처: http://mygumi.tistory.com/181 [마이구미의 HelloWorld]
    * */
    public static void main(String args[]) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] line = bf.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < line.length; i++) {
            char temp = line[i];
            int pr =  priority(temp);

            switch (temp){
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && priority(stack.peek()) >= pr){
                        sb.append(stack.pop());
                    }
                    stack.push(temp);
                    break;
                case '(':
                    stack.push(temp);
                    break;
                case ')':
                    while (!stack.isEmpty() && !stack.peek().equals('(')){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(temp);
                    break;

            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());

    }

    public static int priority(char input){
        switch (input){
            case '*':
            case '/' :
                return 2;
            case '+':
            case '-' :
                return 1;
            case '(':
            case ')' :
                return 0;

        }
        return -1;
    }
}
