package com.sopt.algorithm;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class B_10866 {
/*
push_front X: 정수 X를 덱의 앞에 넣는다.
push_back X: 정수 X를 덱의 뒤에 넣는다.
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
    public static void main(String args[]) {
        Deque<Integer> deque = new LinkedList<>();

        Scanner scn = new Scanner(System.in);
      //  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = scn.nextInt();
        scn.nextLine();

        for (int i = 0; i < count; i++) {
            String temp[] = scn.nextLine().split(" ");
            int num = 0;
            switch (temp[0]) {
                case "push_front" :
                    num = Integer.parseInt(temp[1]);
                    deque.addFirst(num);
                    break;
                case "push_back" :
                    num = Integer.parseInt(temp[1]);
                    deque.addLast(num);
                    break;
                case "pop_front" :
                    if (deque.isEmpty()){
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.pollFirst());
                    }
                    break;
                case "pop_back" :
                    if (deque.isEmpty()){
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.pollLast());
                    }
                    break;
                case "size" :
                    System.out.println(deque.size());
                    break;
                case "empty" :
                    if (deque.isEmpty()){
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front" :
                    if (deque.isEmpty()){
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.peekFirst());
                    }
                    break;
                case "back" :
                    if (deque.isEmpty()){
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.peekLast());
                    }
                    break;

            }

        }
        
    }
}
