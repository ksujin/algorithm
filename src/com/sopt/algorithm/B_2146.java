package com.sopt.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2146 {

    static int n, ans;
    static int[][] map;
    static boolean[][] visit;
    static int[] ax = {-1,0,1,0}, ay = {0,-1,0,1};
    static Queue<Node> q = new LinkedList<>();
    public void solve(){
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        map = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scn.nextInt();
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1 && !visit[i][j]){
                    count++;
                    map[i][j] = count;
                    dfs(i,j, count);
                }
            }
        }

        //꺼내서 주변이 자신이면 continue, 0이면 자신으로, 다른거면 체크! like 토마토
        for (int i = 1; i <= count; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(map[j][k] == i) q.add(new Node(j,k,i));
                    while (!q.isEmpty()){
                        int x = q.peek().x, y = q.peek().y;
                        q.poll();

                        for (int l = 0; l < 4; l++) {
                            int nx = x+ax[l] , ny = y+ay[l];
                            if(nx < 0 || nx >= n || ny < 0 || ny >=n ) continue;
                            if(map[nx][ny] == i) continue;
                            if(map[nx][ny] == 0) map[nx][ny] = i;

                        }
                    }
                }
            }
        }


    }

    //for numbering
    public void dfs(int x, int y, int count){
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x+ax[i], nextY = y + ay[i];
            if (0 > nextX || nextX >= n || 0 > nextY || nextY >= n ) continue;
           // System.out.println(nextX+","+nextY);
            if(map[nextX][nextY] == 1 && !visit[nextX][nextY]) {
                map[nextX][nextY] = count;
                dfs(nextX,nextY,count);
            }


        }
    }

    class Node{
        int x, y, label;
        Node(int x_, int y_, int label_){
            x = x_;
            y = y_;
            label = label_; 
        }
    }

    public static void main(String args[]){
        new B_2146().solve();
    }
}
