package com.sopt.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_1260{
    private static boolean visit[];
    private static int nodeArray[][];
    private static int vertex;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        vertex = scn.nextInt();
        int edge = scn.nextInt();
        int startNode = scn.nextInt();
        nodeArray= new int[vertex+1][vertex+1];
        visit = new boolean[vertex+1];

        for (int i = 1; i <= edge; i++) {
            int firstNode = scn.nextInt();
            int secondNode = scn.nextInt();
            nodeArray[firstNode][secondNode] = 1;
            nodeArray[secondNode][firstNode] = 1;
        }

        a(startNode);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        System.out.println();

        visit = new boolean[vertex+1];

        visit[startNode] = true;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            System.out.print(temp+" ");
            for (int i = 1; i <= vertex; i++) {
                if(nodeArray[temp][i] == 1 && !visit[i]){
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }


    }

    private static void a(int x){
        visit[x] = true;
        System.out.print(x+" ");
        for (int i = 1; i <= vertex ; i++) {
            if (nodeArray[x][i] == 1 && !visit[i]){
                a(i);
            }
        }

    }

}

