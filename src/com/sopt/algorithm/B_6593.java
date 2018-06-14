package com.sopt.algorithm;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B_6593 {
    static int l, row, column, escapeL, escapeR, escapeC, startL, startR, startC;
    static int[] dz = {0,0,0,0,-1,1}, dx={1,-1,0,0,0,0}, dy={0,0,1,-1,0,0};
    static char building[][][];
    static int dist[][][];
    private static final int INF = 10000;
    static Scanner scn = new Scanner(System.in);

    public void solve(int l, int row, int column){

        building = new char[l][row][column];
        dist = new int[l][row][column];

        //입력받기
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < row; j++) {
                String temp = scn.next();
                //System.out.println(temp);
                for (int k = 0; k < column; k++) {
                    char tempChar = temp.charAt(k);
                    if (tempChar == 'E') {
                        escapeL = i;
                        escapeR = j;
                        escapeC = k;
                    }
                    if (tempChar == 'S'){
                        startL = i;
                        startR = j;
                        startC = k;
                    }
                    building[i][j][k] = tempChar;
                    dist[i][j][k] = INF;

                }

            }
        } //입력받기 끝

        dijkstra(startL, startR, startC);

        //System.out.println(dist[escapeL][escapeR][escapeC] < INF ? "Escaped in "+dist[escapeL][escapeR][escapeC]+" minute(s)." : "Trapped!" );



    }

    public void dijkstra(int l, int row, int column){
        dist[l][row][column] = 0;
        PriorityQueue<Element> pq = new PriorityQueue<Element>();
        pq.add(new Element(l,row,column,0));

        while(!pq.isEmpty()){

            int currentZ = pq.peek().z;
            int currentX = pq.peek().x;
            int currentY = pq.peek().y;
            int currentCost = pq.peek().cost;

            pq.poll();

            if (dist[currentZ][currentX][currentY] < currentCost) continue;

            for (int i = 0; i < 6; i++) {
                int az = currentZ+dz[i];
                int ax = currentX+dx[i];
                int ay = currentY+dy[i];

                if (isInRange(az, ax, ay) && hasDoor(az, ax,ay) && dist[az][ax][ay] > dist[currentZ][currentX][currentY] + building[az][ax][ay]){
                    dist[az][ax][ay] = dist[currentZ][currentX][currentY] + 1;
                    if (building[az][ax][ay] == 'E'){
                        System.out.println("Escaped in "+dist[az][ax][ay]+" minute(s).");
                        return;
                    }
                    pq.add(new Element(az,ax,ay,dist[az][ax][ay]));
                }
            }

        }
        System.out.println("Trapped!");

    }

    public boolean isInRange(int z, int x, int y){
        return (0<=z&&z<l)&&(0<=x&&x<row)&&(0<=y&&y<column);
    }

    public boolean hasDoor(int z, int x, int y){
        return building[z][x][y] == '.' || building[z][x][y] == 'E';
    }

    class Element implements Comparable<Element>{
        int z;
        int x;
        int y;
        int cost;

        Element(int z, int x, int y, int cost){
            this.z = z;
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Element o) {
            return this.cost < o.cost ? -1:1;
        }
    }

    public static void main(String[] args){

        while (true){
            l = scn.nextInt();
           row = scn.nextInt();
            column = scn.nextInt();

            if (l == 0 && row == 0 && column == 0) break;
            new B_6593().solve(l, row, column);
        }




    }
}
