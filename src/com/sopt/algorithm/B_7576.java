package com.sopt.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class B_7576 {
    static int width, height, ans;
    static int[][] map;
    static int[] ax = {-1, 0, 1, 0}, ay = {0, -1, 0, 1};
    static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) {


        new B_7576().solve();
    }

    public void solve(){
        Scanner scn = new Scanner(System.in);
        width = scn.nextInt();
        height = scn.nextInt();

        map = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = scn.nextInt();
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(map[i][j]== 1) {
                    q.add(new Node(i,j));
                }
            }
        }

        while (!q.isEmpty()){
            int currentX = q.peek().x;
            int currentY = q.peek().y;
            q.poll();

            //들어간 값들 중 최댓값 구하기
            ans = map[currentX][currentY] > ans ? map[currentX][currentY] : ans;
            for (int i = 0; i < 4; i++) {
                int nextX = currentX+ax[i];
                int nextY = currentY+ay[i];

                if(nextX < 0 || nextX >= height || nextY < 0 || nextY >= width) continue;

                if(map[nextX][nextY] == 0){
                    map[nextX][nextY] = map[currentX][currentY] + 1;
                    q.add(new Node(nextX, nextY));
                }

            }

        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(map[i][j] == 0){
                    ans = 0;
                }
            }
        }
        System.out.println(ans-1);
        
    }

    class Node {
        int x, y;
        Node(int _x, int _y){
            x = _x;
            y = _y;
        }
    }
}
