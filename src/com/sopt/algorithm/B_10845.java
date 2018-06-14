package com.sopt.algorithm;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_10845 {
    /*
     push X: 정수 X를 큐에 넣는 연산이다.
     pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     size: 큐에 들어있는 정수의 개수를 출력한다.
     empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
     front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     */

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int input = scn.nextInt();
        int rear = 1;
        scn.nextLine();
        for (int i = 0; i < input; i++) {

            String temp[] = scn.nextLine().split(" ");
           // System.out.println(input);
            switch (temp[0]) {
                case "push" :
                    int tempNumb = Integer.parseInt(temp[1]);
                    q.add(tempNumb);
                    rear = tempNumb;
                        break;
                case "pop" :
                    if (!q.isEmpty()){
                        System.out.println(q.poll());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "size" :
                    System.out.println(q.size());
                    break;
                case "empty" :
                    if(q.isEmpty()){
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front" :
                    if (!q.isEmpty()){
                        System.out.println(q.peek());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "back" :
                    if (!q.isEmpty()){
                        System.out.println(rear);
                    } else {
                        System.out.println(-1);
                    }
                    break;


            }

        }
    }

}
