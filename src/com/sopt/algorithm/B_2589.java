package com.sopt.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2589 {
    static int ax[] = {-1,0,1,0};
    static int ay[] = {0,-1,0,1};
    static int n, m;
    static boolean visit[][];
    static int map[][];
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
         n = scn.nextInt();
         m = scn.nextInt();
         map= new int[n][m];

        //input
        for (int i = 0; i < n; i++) {
            String temp = scn.next();
            for (int j = 0; j < m; j++) {
                char tempC = temp.charAt(j);
                if (tempC == 'L'){
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        } //input

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) continue;
                //start
                max = max > bfs(i, j) ? max : bfs(i, j);
            }
        }

        System.out.println(max-1);


    }

    static int bfs(int x, int y){
        visit = new boolean[n][m];
        int max = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        visit[x][y] = true;
        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Point current = q.poll();

                for (int j = 0; j < 4; j++) {
                    //System.out.println(j);
                    int nextX = current.x+ax[j];
                    int nextY = current.y+ay[j];

                    if (isInRange(nextX,nextY) && !visit[nextX][nextY] && map[nextX][nextY] == 1){

                        q.offer(new Point(nextX,nextY));
                        visit[nextX][nextY] = true;
                    }
                } //for 4

            } //for size
            max++;
        } //while

        return max;
    }

    static boolean isInRange(int x, int y){
        if (0 <= x && 0 <= y && x < n && y < m){
            return true;
        }
        return false;
    }
}

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
