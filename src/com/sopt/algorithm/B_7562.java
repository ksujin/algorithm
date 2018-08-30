package com.sopt.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_7562 {
    static Scanner scn = new Scanner(System.in);
    static int n;
    static int ax[] = {-1,-2,-2,-1,1,2,2,1};
    static int ay[] = {2,1,-1,-2,-2,-1,1,2};
    public static void main(String args[]){
        int testCase = scn.nextInt();
        for (int i = 0; i < testCase; i++) {
            solve();
        }
    }

    static void solve(){
        n = scn.nextInt();
        int startX = scn.nextInt();
        int startY = scn.nextInt();
        int endX = scn.nextInt();
        int endY = scn.nextInt();
        boolean visit[][] = new boolean[n][n];
        Element1 startNode = new Element1(startX, startY);
        Element1 endNode = new Element1(endX, endY);

        if(isEqual(startNode, endNode)){
            System.out.println(0);
            return;
        }

        Queue<Element1> q = new LinkedList<>();
        q.offer(new Element1(startX, startY));
        visit[startX][startY] = true;
        int ans = 0;
        while (!q.isEmpty()){
            ans++;
            int size = q.size();
            for (int j = 0; j < size; j++) {

                Element1 current = q.poll();

                for (int i = 0; i < 8; i++) {
                    int nextX = current.x+ax[i];
                    int nextY = current.y+ay[i];
                    if (isInRange(nextX, nextY)) {
                        if (visit[nextX][nextY]) continue;
                        Element1 nextNode = new Element1(nextX, nextY);
                        if (isEqual(nextNode, endNode)){
                            System.out.println(ans);
                            return;
                        } else {

                            q.offer(nextNode);
                            visit[nextX][nextY] = true;
                        }
                    } //isinRange
                } // for 8

            } //for q.size

        } //while

    }

    static boolean isInRange(int x, int y){
        if (0 <= x && 0 <= y && x < n && y < n){
            return true;
        }
        return false;
    }

    static boolean isEqual(Element1 first, Element1 second){
        if (first.x == second.x && first.y == second.y){
            return true;
        }
        return false;
    }
}

class Element1{
    int x;
    int y;
    Element1(int x, int y){
        this.x = x;
        this.y = y;
    }
}