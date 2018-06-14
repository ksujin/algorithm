package com.sopt.algorithm;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B_2178 {
    static int[][] map, dist;
    static int height, width;
    static int[] ax = {-1, 0, 1, 0}, ay = {0, -1, 0, 1};
    final static int INF = 10001;

    public void solve(){
        Scanner scn = new Scanner(System.in);
        height = scn.nextInt();
        width = scn.nextInt();
        scn.nextLine();
        map = new int[height][width];
        dist = new int[height][width];
        for (int i = 0; i < height; i++) {
            String tempString = scn.nextLine();
            for (int j = 0; j < width; j++) {
                char tempChar = tempString.charAt(j);
                int tempInt = Character.getNumericValue(tempChar);
                map[i][j] = tempInt;
                dist[i][j] = INF;
            }
        }

        dijkstra(0,0);

        System.out.println(dist[height-1][width-1]);

    }

    public void dijkstra(int x, int y){
        PriorityQueue<Element> pq = new PriorityQueue<>();
        pq.add(new Element(x,y,0));
        dist[x][y] = 1;
        while (!pq.isEmpty()){

            int currentX = pq.peek().x;
            int currentY = pq.peek().y;
            int currentCost = pq.peek().cost;
           // System.out.println("current is (" + currentX +","+currentY+") = "+currentCost);

            pq.poll();

            if (dist[currentX][currentY] < currentCost) continue;

            for (int i = 0; i < 4; i++) {
                int nextX = currentX+ax[i];
                int nextY = currentY+ay[i];



                if(!isInRange(nextX, nextY)) continue;

                   if(  map[nextX][nextY] == 1 &&
                        dist[currentX][currentY] + 1 < dist[nextX][nextY] ){
                        dist[nextX][nextY] = dist[currentX][currentY] + 1;
                   // System.out.println("next is (" + nextX +","+nextY+") = "  +dist[nextX][nextY]);

                        pq.add(new Element(nextX, nextY, dist[nextX][nextY]));
                }
            }

        }

    }

    public static boolean isInRange(int x, int y){
        if(0 <= x && x < height && 0 <= y && y < width){
            return true;
        }
        return false;
    }

    class Element implements Comparable<Element>{
        int x;
        int y;
        int cost;

        Element(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Element o) {
            return this.cost < o.cost ? -1:1;
        }
    }


    public static void main(String args[]){
        new B_2178().solve();
    }

}

