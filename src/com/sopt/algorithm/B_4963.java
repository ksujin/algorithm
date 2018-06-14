package com.sopt.algorithm;

import java.util.Scanner;

public class B_4963 {

    static Scanner scn = new Scanner(System.in);
    static int[][] map;
    static boolean[][] visit;
    static int width, height, count;
    static int[] ax = {-1, -1, -1, 0, 1, 1, 1, 0}, ay = {-1, 0, 1, 1, 1, 0, -1, -1};
    public void solve(int n, int m){
        //5*4
        map = new int[n][m];
        visit = new boolean[n][m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                map[i][j] = scn.nextInt();
            }

        }


        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j] && map[i][j] == 1){
                    count++;
                    bfs(i,j);
                }
            }
        }
        System.out.println(count);
    }

    public static void bfs(int x, int y){
        visit[x][y] = true;
        for (int i = 0; i < 8; i++) {
                int nextX = x+ax[i];
                int nextY = y+ay[i];
               // System.out.println("nextX,nextY = ("+nextX+","+nextY+")");
                if(isInRange(nextX, nextY) && !visit[nextX][nextY] && map[nextX][nextY] == 1){

                    bfs(nextX, nextY);
                }

        }
    }

    public static boolean isInRange(int x, int y){
        if(0 <= x && x < width && 0 <= y && y < height){
            return true;
        }
        return false;
    }

    public static void main(String args[]){
        while(true) {
            width = scn.nextInt();
            height = scn.nextInt();
            if(width == 0 && height == 0) {
                return;
            }

            new B_4963().solve(width, height);
        }


    }

}
